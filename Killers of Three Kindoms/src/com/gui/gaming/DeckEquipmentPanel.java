package com.gui.gaming;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import com.card.equipment.BlackPommelCard;
import com.card.equipment.EightDiagramFormationCard;
import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.utils.DebugUtil;
import com.system.utils.ResUtil;

public class DeckEquipmentPanel extends JPanel{


	private static final long serialVersionUID = -2232599134692339919L;
	APlayer player;
	DeckEquipmentSubPanel weapon;
	DeckEquipmentSubPanel armor;
	DeckEquipmentSubPanel horseAttact;
	DeckEquipmentSubPanel horseDefend;
	BufferedImage bg;
	
	public DeckEquipmentPanel(APlayer player){
		this.setOpaque(false);
		this.player = player;
		this.setLayout(new GridLayout(4, 1));
		this.setBackground(Color.WHITE);
		resInitial();
		weapon = new DeckEquipmentSubPanel();
		armor = new DeckEquipmentSubPanel();
		horseAttact = new DeckEquipmentSubPanel();
		horseDefend = new DeckEquipmentSubPanel();
		this.add(weapon);
		this.add(armor);
		this.add(horseAttact);
		this.add(horseDefend);
	}
	
	private void resInitial(){
		bg = ResUtil.getImgByName("bg_equipment", 0);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(),null);
	}
	
	public void setAEquipment(ACard card){
		if(card.getType() == CardConst.CardType_Weapon){
			weapon.setCard(card);
		}else if(card.getType() == CardConst.CardType_Armor){
			armor.setCard(card);
		}else if(card.getType() == CardConst.CardType_Mount_Minus){
			horseAttact.setCard(card);
		}else if(card.getType() == CardConst.CardType_Mount_Plus){
			horseDefend.setCard(card);
		}
	}
	
	class DeckEquipmentSubPanel extends JPanel{
		
		private static final long serialVersionUID = -4080521922706576417L;
		Border border;
		String name = "";
		public DeckEquipmentSubPanel(){
			this.setOpaque(false);
			this.setLayout(null);
			border = BorderFactory.createLineBorder(Color.BLACK, 1);
			this.setBorder(border);
		}
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			g.setColor(Color.gray);
			g.drawString(name, this.getWidth() / 2 - 8, this
					.getHeight() / 3 * 2 + 5);
		}
		
		public void setCard(ACard card){
			name = card.getName();
			repaint();
		}
	}
}
