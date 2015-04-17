package com.gui.gaming;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.card.base.DodgeCard;
import com.card.base.PeachCard;
import com.card.base.StrikeCard;
import com.card.interfaces.ACard;
import com.system.constants.GUIConst;
import com.system.utils.DebugUtil;

/**
 * A panel for handcard
 * @author liuh4
 *
 */
public class DeckHandCardPanel extends JPanel{

	private static final long serialVersionUID = -5337278012812148749L;

	List<CardPanel> cardPanels;
	
	List<ACard> cards;
	
	BtnPanel sureBtnPanel;
	BtnPanel cancelBtnPanel;
	BtnPanel skipBtnPanel;
	
	MouseListener listener;
	
	boolean isCardAvailablePanel;
	
	public DeckHandCardPanel(){
		this.setLayout(null);
		initial();
		this.add(sureBtnPanel);
		this.add(cancelBtnPanel);
		this.add(skipBtnPanel);
		sureBtnPanel.setLocation(GUIConst.cardWidth * 5 + GUIConst.btnSureOffset, 20);
		cancelBtnPanel.setLocation(GUIConst.cardWidth * 5 + GUIConst.btnSureOffset,
				sureBtnPanel.getHeight() + sureBtnPanel.getY());
		skipBtnPanel.setLocation(GUIConst.cardWidth * 5 + GUIConst.btnSureOffset,
				sureBtnPanel.getHeight() + cancelBtnPanel.getHeight()
						+ GUIConst.btnSkipOffset);
	}
	
	private void initial(){
		cardPanels = new ArrayList<CardPanel>();
		cards = new ArrayList<>();
		sureBtnPanel = new BtnPanel("Sure");
		cancelBtnPanel = new BtnPanel("Cancel");
		skipBtnPanel = new BtnPanel("Skip");
		cardInitial();
	}
	
	private void addDataForTest(){
		PeachCard peachCard = new PeachCard();
		cardPanels.add(new CardPanel(peachCard));
		DodgeCard dodgeCard = new DodgeCard();
		cardPanels.add(new CardPanel(dodgeCard));
		StrikeCard strikeCard = new StrikeCard();
		DodgeCard dodgeCard2 = new DodgeCard();
		cardPanels.add(new CardPanel(dodgeCard2));
		cardPanels.add(new CardPanel(strikeCard));
	}
	
	private void cardInitial(){
		addDataForTest();
		for (int i = 0; i < cardPanels.size(); i++) {
			this.add(cardPanels.get(i));
		}
		this.repaint();
		for (int i = 0; i < cardPanels.size(); i++) {
			cardPanels.get(i).setLocation(i * GUIConst.cardWidth, GUIConst.cardUp);

		}
	}
	
	void setUnableClick(){
		isCardAvailablePanel = false;
		this.removeMouseListener(listener);
		this.setCursor(Cursor.getDefaultCursor());
		repaint();
	}
	
	void setEnableClick(){
		isCardAvailablePanel = true;
		if (this.getMouseListeners().length == 0)
			this.addMouseListener(listener);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
	}
	/**
	 * this is a panel for
	 * 1.confirm casting card
	 * 2.cancel select
	 * 3.drop card
	 * @author liuh4
	 *
	 */
	class BtnPanel extends JPanel{

		private static final long serialVersionUID = 1802023971429379500L;
		JLabel text = new JLabel();
		MouseListener listener;
		
		public BtnPanel(String name){
			this.setSize(80,45);
			this.setLayout(null);
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
			text.setForeground(Color.white);
			text.setText(name);
			this.setForeground(Color.white);
			this.add(text);
			text.setSize(80,45);
			text.setHorizontalAlignment(SwingConstants.CENTER);
			this.setBackground(Color.white);
			if(name.equals("Sure")){
				listener = new SureListener();
			}else if(name.equals("Cancel")){
				listener = new CancelListener();
			}else if(name.equals("Skip")){
				listener = new skipListener();
			}
			this.addMouseListener(listener);
		}
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			g.drawRect(0, 0, this.getWidth(), this.getHeight());
			super.paintChildren(g);
			g.dispose();
		}
		
		class MyClick extends MouseAdapter{
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				DebugUtil.print("mousePressed");
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
			}
			
			private void clicked() {
				
			}
			
			
		}
		
		class CancelListener extends MyClick{
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				for (int i = 0; i < cardPanels.size(); i++) {
					if(cardPanels.get(i).isSelected){
						cardPanels.get(i).unselect();
					}
				}
			}
		}
		
		class skipListener extends MyClick{
			
		}
		
		class SureListener extends MyClick{
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				for (int i = 0; i < cardPanels.size(); i++) {
					if(cardPanels.get(i).isSelected){
						CardPanel tmp = cardPanels.get(i);
						BattleFieldPanel.Instance().addACard(tmp.getCard());
						tmp.unselect();
					}
				}
			}
		}
	}
}
