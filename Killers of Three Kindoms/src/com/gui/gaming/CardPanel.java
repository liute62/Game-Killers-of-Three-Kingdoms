package com.gui.gaming;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.card.interfaces.ACard;
import com.system.constants.CardConst;
import com.system.constants.GUIConst;
import com.system.utils.CardUtil;
import com.system.utils.PlayerUtil;

/**
 * This is a panel for a card
 * @author liuh4
 *
 */
public class CardPanel extends JPanel{


	private static final long serialVersionUID = 4192067258235873873L;
	boolean isSelected = false;
	private boolean selectable = true;
	int id = -1;
	String cardName = "card";
	MouseListener listener;
	private ACard card;
	private int effectRange;
	

	public CardPanel(ACard card){
		this.setSize(GUIConst.cardWidth,GUIConst.cardHeight);
		this.setForeground(Color.BLACK);
		borderInitial(card);
		this.id = id;
		this.setCard(card);
		this.cardName = card.getName();
		listener = new Mouse(this);
		this.addMouseListener(listener);
		this.requestFocus();
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, 18));
		g.drawString(cardName, 15, 20);
	}
	
	public void unselect(){
		this.setLocation(this.getX(), this.getY() + 50);
		this.setSelected(false);
		List<OtherPlayerPanel> panels = PlayerUtil.getInstance().getPlayerPanels();
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).unselect();
			panels.get(i).unBorder();
		}
	}
	
	public void select(){
		//check other cardpanel to see if they are selected
		List<CardPanel> tmp = CardUtil.getInstance().getPlayerHandCardPanels();
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i).isSelected) {
				tmp.get(i).unselect();
			}
		}
		this.setLocation(this.getX(), this.getY() - 50);
		this.setSelected(true);
		List<OtherPlayerPanel> panels = PlayerUtil.getInstance().getPlayerPanels();
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).untarget();
		}
		panels = getTargetPlayerPanels();
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).target();
		}
	}
	
	public List<OtherPlayerPanel> getTargetPlayerPanels(){
		List<OtherPlayerPanel> result = new ArrayList<OtherPlayerPanel>();
		//check the available target by the card.
		List<OtherPlayerPanel> tmp = PlayerUtil.getInstance().getPlayerPanels();
		/**To Do**/
		result.add(tmp.get(0));
		result.add(tmp.get(1));
		return result;
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
				if (card.isSelected) {
					card.unselect();
				} else {
					card.select();
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
}
