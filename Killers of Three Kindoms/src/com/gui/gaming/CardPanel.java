package com.gui.gaming;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.constants.GUIConst;
import com.system.utils.CardUtil;
import com.system.utils.PlayerUtil;
import com.system.utils.ResUtil;

/**
 * This is a panel for a card
 * @author liuh4
 *
 */
public class CardPanel extends JPanel{


	private static final long serialVersionUID = 4192067258235873873L;
	boolean isSelected = false;
	private boolean selectable = true;
	private boolean isUsed;
	int id = -1;
	String cardName = "card";
	MouseListener listener;
	private ACard card;
	private int effectRange;
	BufferedImage bg;
	private boolean isDiscardStage;

	public CardPanel(ACard card){
		this.setOpaque(false);
		this.setSize(GUIConst.cardWidth,GUIConst.cardHeight);
		this.setForeground(Color.BLACK);
		this.isUsed = false;
		this.isDiscardStage = false;	
		this.setCard(card);
        resInitial();
        this.cardName = card.getName();
		listener = new Mouse(this);
		this.addMouseListener(listener);
		this.requestFocus();
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	private void resInitial(){
//		bg = ResUtil.getImgByName("basic_strike", 1);
        bg = getCard().getProfile();
	}
	
	private void borderInitial(ACard card){
		if (card.getType() == CardConst.CardType_Strike) {
			this.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		}if (card.getType() == CardConst.CardType_Dodge) {
			this.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
		}if (card.getType() == CardConst.CardType_Peach) {
			this.setBorder(BorderFactory.createLineBorder(Color.orange, 3));
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if (isUsed) {
			g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight()-50,null);
		}else {
			g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(),null);	
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, 18));
		g.drawString(cardName, 15, 20);
	}
	
	public void selectForDiscard(){
		this.setLocation(this.getX(), this.getY() - 50);
		repaint();
		this.setSelected(true);
		APlayer player = PlayerUtil.getInstance().getPlayer();
		player.getDiscardList().add(this.getCard());
		if (player.isCanDiscard()) {
			DeckHandCardPanel.getTheInstance().setConfirmBtnClickable();
		}else {
			DeckHandCardPanel.getTheInstance().setConfirmBtnUnClickable();
		}
	}
	
	public void unselectFoDiscard(){
		APlayer player = PlayerUtil.getInstance().getPlayer();
		player.getDiscardList().remove(this.getCard());
		this.setLocation(this.getX(), this.getY() + 50);
		this.setSelected(false);
		if (player.isCanDiscard()) {
			DeckHandCardPanel.getTheInstance().setConfirmBtnClickable();
		}else {
			DeckHandCardPanel.getTheInstance().setConfirmBtnUnClickable();
		}
	}
	
	public void unselect(){
		DeckHandCardPanel.getTheInstance().setCancelBtnUnClikable();
		this.setLocation(this.getX(), this.getY() + 50);
		this.setSelected(false);
		List<OtherPlayerPanel> panels = PlayerUtil.getInstance().getPlayerPanels();
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).unselect();
			panels.get(i).unBorder();
		}
		DeckHandCardPanel.getTheInstance().setConfirmBtnUnClickable();
	}
	
	public void select(){
		//check other cardpanel to see if they are selected
		DeckHandCardPanel.getTheInstance().setCancelBtnClickable();
		List<CardPanel> tmp = CardUtil.getInstance().getPlayerHandCardPanels();
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i).isSelected) {
				tmp.get(i).unselect();
			}
		}
		this.setLocation(this.getX(), this.getY() - 50);
		repaint();
		this.setSelected(true);
		List<OtherPlayerPanel> panels = PlayerUtil.getInstance().getPlayerPanels();
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).untarget();
		}
		panels = getTargetPlayerPanels();
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).target();
		}
		//check if it can be casted
		DeckHandCardPanel.getTheInstance().setConfirmBtnClickable();
		DeckHandCardPanel.getTheInstance().setCancelBtnClickable();
	}
	
	public List<OtherPlayerPanel> getTargetPlayerPanels(){
		List<OtherPlayerPanel> result = new ArrayList<OtherPlayerPanel>();
		//check the available target by the card.
		List<OtherPlayerPanel> tmp = PlayerUtil.getInstance().getPlayerPanels();
		/**To Do**/
		result.add(tmp.get(0));
		result.add(tmp.get(1));
        result.add(tmp.get(2));
        result.add(tmp.get(3));
		return result;
	}
	
	public List<APlayer> getTargetPlayers() {
		List<APlayer> allPlayers = new ArrayList<APlayer>();
		List<APlayer> targetPlayers = new ArrayList<APlayer>();
		
		allPlayers = PlayerUtil.getInstance().getPlayers();
		for(int i = 1; i < allPlayers.size(); i ++)
		{
			int distance;
			distance = PlayerUtil.getDistance(allPlayers.get(0), allPlayers.get(i));
			if(distance <= this.effectRange)
			{
				targetPlayers.add(allPlayers.get(i));
			}
		}
		return targetPlayers;
	}
	
	public void checkEffectRange() {
		if(card.getType() == CardConst.CardType_Strike) 
		{
			this.effectRange = PlayerUtil.getInstance().getPlayer().getAttackRange();
		}
	}
	
	public int getEffectRange() {
		return effectRange;
	}

	public void setEffectRange(int effectRange) {
		this.effectRange = effectRange;
	}
	
	
	class Mouse extends MouseAdapter{
		CardPanel card;
		public Mouse(CardPanel card){
			this.card = card;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (card.isSelectable()) {
				if (isDiscardStage) {
					if (card.isSelected) {
						card.unselectFoDiscard();
					} else {
						card.selectForDiscard();
					}	
				}else {
					if (card.isSelected) {
						card.unselect();
					} else {
						card.select();
					}	
				}
			}
		}
	}
	
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public ACard getCard() {
		return card;
	}

	public void setCard(ACard card) {
		this.card = card;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
		repaint();
	}
	
	public void setDiscardStage(boolean isDiscardStage){
		this.isDiscardStage = isDiscardStage;
	}
}
