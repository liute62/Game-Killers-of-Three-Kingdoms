package com.gui.gaming;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
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
import com.system.utils.PlayerUtil;
import com.system.utils.ResUtil;

/**
 * A panel for handcard
 * @author liuh4
 *
 */
public class DeckHandCardPanel extends JPanel{

	private static final long serialVersionUID = -5337278012812148749L;
	private static DeckHandCardPanel instance;
	APlayer player;
	List<CardPanel> cardPanels;
	BtnPanel confirmBtnPanel;
	BtnPanel cancelBtnPanel;
	BtnPanel skipBtnPanel;
	MouseListener listener;
	boolean isCardAvailablePanel;
	BufferedImage bg;
	private boolean isDiscardStage;
	
	public static DeckHandCardPanel getTheInstance(){
		return instance;
	}
	
	public DeckHandCardPanel(APlayer player){
		instance = this;
		this.setOpaque(false);
		this.player = player;
		this.player.setDeckHandCardPanel(this);
		this.setLayout(null);
		this.isDiscardStage = false;
		resInitial();
		initial();
		this.add(confirmBtnPanel);
		this.add(cancelBtnPanel);
		this.add(skipBtnPanel);
		confirmBtnPanel.setLocation(GUIConst.cardWidth * 5 + GUIConst.btnSureOffset, 20);
		cancelBtnPanel.setLocation(GUIConst.cardWidth * 5 + GUIConst.btnSureOffset,
				confirmBtnPanel.getHeight() + confirmBtnPanel.getY());
		skipBtnPanel.setLocation(GUIConst.cardWidth * 5 + GUIConst.btnSureOffset,
				confirmBtnPanel.getHeight() + cancelBtnPanel.getHeight()
						+ GUIConst.btnSkipOffset);
	}
	
	private void resInitial(){
		bg = ResUtil.getImgByName("bg_hand_card",0);
	}
	
	private void initial(){
		cardPanels = new ArrayList<CardPanel>();
		confirmBtnPanel = new BtnPanel("Confirm");
		cancelBtnPanel = new BtnPanel("Cancel");
		skipBtnPanel = new BtnPanel("Skip");
        addData();
		cardPanelInitial();
	}

    private void addData() {
    	DebugUtil.print("Deck HandCard AddData",player.getHands().size());
    	cardPanels.clear();
       for (int i = 0; i < player.getHands().size(); i++) {
            cardPanels.add(new CardPanel(player.getHands().get(i)));
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
	
	public void setConfirmBtnClickable(){
		confirmBtnPanel.setClickable(true);
	}
	
	public void setConfirmBtnUnClickable(){
		confirmBtnPanel.setClickable(false);
	}
	
	public void setCancelBtnClickable(){
		cancelBtnPanel.setClickable(true);
	}
	
	public void setCancelBtnUnClikable(){
		cancelBtnPanel.setClickable(false);
	}
	
	public void setSkipBtnClickable(){
		skipBtnPanel.setClickable(true);
	}
	
	public void setSkipBtnUnClikable(){
		skipBtnPanel.setClickable(false);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(),null);
		super.paint(g);
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
		cardPanels.clear();
		for (int i = 0; i < player.getHands().size(); i++) {
			CardPanel panel = new CardPanel(player.getHands().get(i));
			if (isDiscardStage) {
				panel.setDiscardStage(true);
			}else {
				panel.setDiscardStage(false);
			}
			cardPanels.add(panel);
		}
		cardPanelInitial();
	}
	
	public boolean isDiscardStage() {
		return isDiscardStage;
	}

	public void setDiscardStage(boolean isDiscardStage) {
		this.isDiscardStage = isDiscardStage;
		this.refresh();
	}

	/**
	 * this is a panel for
	 * 1.confirm casting card
	 * 2.cancel select
	 * 3.drop card
	 * @author liuh4
	 *
	 */
	public class BtnPanel extends JPanel{

		private static final long serialVersionUID = 1802023971429379500L;
		MouseListener listener;
		BufferedImage bg_clickable;
		BufferedImage bg_unClickable;
		private boolean isClickable;
		
		public BtnPanel(String name){
			this.setOpaque(false);
			this.setSize(80,45);
			this.setLayout(null);
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
			if(name.equals("Confirm")){
				isClickable = false;
				bg_clickable = ResUtil.getImgByName("bg_btn_confirm_highlight", 1);
				bg_unClickable = ResUtil.getImgByName("bg_btn_confirm_gray", 1);
				listener = new SureListener();
			}else if(name.equals("Cancel")){
				isClickable = false;
				bg_clickable = ResUtil.getImgByName("bg_btn_cancel_highlight", 1);
				bg_unClickable = ResUtil.getImgByName("bg_btn_cancel_gray", 1);
				listener = new CancelListener();
			}else if(name.equals("Skip")){
				isClickable = true;
				bg_clickable = ResUtil.getImgByName("bg_btn_skip_highlight", 1);
				bg_unClickable = ResUtil.getImgByName("bg_btn_skip_gray", 1);
				listener = new skipListener();
			}
			this.addMouseListener(listener);
		}
		
		public void setClickable(boolean isClickable) {
			this.isClickable = isClickable;
			repaint();
		}
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			//g.drawRect(0, 0, this.getWidth(), this.getHeight());
			super.paint(g);
			if (isClickable) {
				g.drawImage(bg_clickable, 0, 0, this.getWidth(), this.getHeight(),null);			
			}else {
				g.drawImage(bg_unClickable, 0, 0, this.getWidth(), this.getHeight(),null);			
			}
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
				if (isClickable) {
					for (int i = 0; i < cardPanels.size(); i++) {
						if(cardPanels.get(i).isSelected){
							cardPanels.get(i).unselect();
						}
					}	
				}
			}
		}
		
		class skipListener extends MyClick{
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				if (isClickable) {
					DebugUtil.print("pressed skip player id:"+player.getId());
					DebugUtil.print(player.isSkipped());
					player.setSkipped(true);
					DebugUtil.print(player.isSkipped());	
				}
			}
		}
		
		class SureListener extends MyClick{
			
			List<CardPanel> removedList = new ArrayList<CardPanel>();
			List<ACard> removedCards = new ArrayList<ACard>();
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				if (isClickable) {
					if (isDiscardStage) {
						discard();
					}else {
						castcard();	
					}
					player.getHands().removeAll(removedCards);
					cardPanels.removeAll(removedList);
					cardPanelInitial();	
				}
				isClickable = false;
			}
			
			private void discard(){
				for (int i = 0; i < cardPanels.size(); i++) {
					if(cardPanels.get(i).isSelected){
						CardPanel tmp = cardPanels.get(i);
						removedList.add(tmp);
						removedCards.add(tmp.getCard());
						BattleFieldPanel.Instance().addADiscard(player, tmp.getCard());
						tmp.unselectFoDiscard();
						DeckHandCardPanel.this.remove(tmp);
					}
				}
			}
			
			private void castcard(){
				player.setTargetPlayer(PlayerUtil.getInstance().getTargertPlayer());
				for (int i = 0; i < cardPanels.size(); i++) {
					if(cardPanels.get(i).isSelected){
						CardPanel tmp = cardPanels.get(i);
						if (tmp.getCard().getType() == CardConst.CardType_Weapon || 
								tmp.getCard().getType() == CardConst.CardType_Armor||
								tmp.getCard().getType() == CardConst.CardType_Mount_Minus||
								tmp.getCard().getType() == CardConst.CardType_Mount_Plus) {
							player.setTargetPlayer(player);
						}if (tmp.getCard().getType() == CardConst.CardType_Scroll_Card) {
							if (tmp.getCard().getName().equals("PeachGarden")) {
								List<APlayer> players = PlayerUtil.getInstance().getPlayers();
								player.setTargetPlayer(null);
								player.setTargetPlayers(players);
							}
						}
						
						if (player.getTargetPlayer() != null) {
							//this card can be used
							List<APlayer> tmpList = new ArrayList<APlayer>();
							tmpList.add(player.getTargetPlayer());
							BattleFieldPanel.Instance().addACard(player,tmp.getCard());
							tmp.getCard().use(player, tmpList);	
							removedList.add(tmp);
							removedCards.add(tmp.getCard());
							tmp.unselect();
							DeckHandCardPanel.this.remove(tmp);
							player.getHands().remove(tmp.getCard());
							player.setCastingcard(true);
						}else if (player.getTargetPlayers() != null){
							BattleFieldPanel.Instance().addNoneTargetACard(player, tmp.getCard());
							tmp.getCard().use(player, player.getTargetPlayers());
							removedList.add(tmp);
							removedCards.add(tmp.getCard());
							tmp.unselect();
							DeckHandCardPanel.this.remove(tmp);
							player.getHands().remove(tmp.getCard());
							player.setCastingcard(true);
						}else {
							tmp.unselect();
							player.setCastingcard(false);
						}
					}
				}
			}
			
		}
	}
}
