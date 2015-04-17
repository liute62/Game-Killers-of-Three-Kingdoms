package com.gui.gaming;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.card.interfaces.ACard;
import com.system.constants.GUIConst;

/**
 * This is a panel for a card
 * @author liuh4
 *
 */
public class CardPanel extends JPanel{


	private static final long serialVersionUID = 4192067258235873873L;
	boolean isSelected = false;
	int id = -1;
	String cardName = "card";
	MouseListener listener;
	private ACard card;
	
	public CardPanel(ACard card){
		this.setSize(GUIConst.cardWidth,GUIConst.cardHeight);
		this.setForeground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.orange, 3));
		this.id = id;
		this.setCard(card);
		this.cardName = card.getName();
		listener = new Mouse(this);
		this.addMouseListener(listener);
		this.requestFocus();
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, 18));
		g.drawString(cardName, 15, 115);
	}
	
	public void unselect(){
		this.setLocation(this.getX(), this.getY() + 50);
		this.setSelected(false);
	}
	
	public void select(){
		this.setLocation(this.getX(), this.getY() - 50);
		this.setSelected(true);
	}
	
	class Mouse extends MouseAdapter{
		CardPanel card;
		public Mouse(CardPanel card){
			this.card = card;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (card.isSelected) {
				card.unselect();
			} else {
				card.select();
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
}
