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
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.constants.GUIConst;
import com.system.utils.CardUtil;
import com.system.utils.DebugUtil;

/**
 * A panel for handcard
 * @author liuh4
 *
 */
public class DeckHandCardPanel extends JPanel{

	private static final long serialVersionUID = -5337278012812148749L;
	APlayer player;
	List<CardPanel> cardPanels;
	BtnPanel sureBtnPanel;
	BtnPanel cancelBtnPanel;
	BtnPanel skipBtnPanel;
	MouseListener listener;
	boolean isCardAvailablePanel;
	
	public DeckHandCardPanel(APlayer player){
		this.player = player;
		this.player.setDeckHandCardPanel(this);
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
		sureBtnPanel = new BtnPanel("Sure");
		cancelBtnPanel = new BtnPanel("Cancel");
		skipBtnPanel = new BtnPanel("Skip");
		addDataForTest();
		cardPanelInitial();
	}
	
	private void addDataForTest(){
		List<ACard> cards = CardUtil.getInstance().getInitialCards(player);
		player.setHands(cards);
		for (int i = 0; i < cards.size(); i++) {
			cardPanels.add(new CardPanel(cards.get(i)));
		}
	}
	
	private void cardPanelInitial(){
		for (int i = 0; i < cardPanels.size(); i++) {
			this.add(cardPanels.get(i));
		}
		this.repaint();
		for (int i = 0; i < cardPanels.size(); i++) {
			cardPanels.get(i).setLocation(i * GUIConst.cardWidth, GUIConst.cardUp);
		}
		CardUtil.getInstance().setPlayerHandCardPanels(cardPanels);
		carding();
	}
	
	public void carding() {
		int interval = GUIConst.cardWidth;
		if (cardPanels.size() > 5) {
			interval = (GUIConst.cardWidth * 5 - GUIConst.cardWidth)
					/ (cardPanels.size() - 1);
		}
		for (int i = 0; i < cardPanels.size(); i++) {
			cardPanels.get(i).setLocation(i * interval, GUIConst.cardUp);
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
	
	public void refresh(){
		for (int i = 0; i < cardPanels.size(); i++) {
			this.remove(cardPanels.get(i));
		}
		for (int i = 0; i < player.getHands().size(); i++) {
			cardPanels.add(new CardPanel(player.getHands().get(i)));
		}
		cardPanelInitial();
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
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				DebugUtil.print("pressed skip player id:"+player.getId());
				DebugUtil.print(player.isSkipped());
				player.setSkipped(true);
				DebugUtil.print(player.isSkipped());
			}
		}
		
		class SureListener extends MyClick{
			
			List<CardPanel> removedList = new ArrayList<>();
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				List<CardPanel> removedList = new ArrayList<>();
				for (int i = 0; i < cardPanels.size(); i++) {
					if(cardPanels.get(i).isSelected){
						CardPanel tmp = cardPanels.get(i);
						if (player.getAvailableCards(player.getHands()).contains(tmp.getCard())) {
							//this card can be used
							removedList.add(tmp);
							BattleFieldPanel.Instance().addACard(player,tmp.getCard());
							tmp.unselect();
							DeckHandCardPanel.this.remove(tmp);
							player.setCastingcard(true);
						}else {
							tmp.unselect();
							player.setCastingcard(false);
						}
						
					}
				}
				cardPanels.removeAll(removedList);
				cardPanelInitial();
			}
			
		}
	}
}
