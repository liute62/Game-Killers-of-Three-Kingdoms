package com.gui.gaming;

import java.awt.Color;
import java.awt.GridLayout;

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

public class DeckEquipmentPanel extends JPanel{


	private static final long serialVersionUID = -2232599134692339919L;
	APlayer player;
	DeckEquipmentSubPanel weapon;
	DeckEquipmentSubPanel armor;
	DeckEquipmentSubPanel horseAttact;
	DeckEquipmentSubPanel horseDefend;
	
	public DeckEquipmentPanel(APlayer player){
		this.player = player;
		this.setLayout(new GridLayout(4, 1));
		this.setBackground(Color.WHITE);
		weapon = new DeckEquipmentSubPanel();
		armor = new DeckEquipmentSubPanel();
		horseAttact = new DeckEquipmentSubPanel();
		horseDefend = new DeckEquipmentSubPanel();
		this.add(weapon);
		this.add(armor);
		this.add(horseAttact);
		this.add(horseDefend);
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
		JLabel name;
		public DeckEquipmentSubPanel(){
			this.setLayout(null);
			border = BorderFactory.createLineBorder(Color.BLACK, 1);
			this.setBorder(border);
		}
		
		public void setCard(ACard card){
			name = new JLabel(card.getName());
			name.setSize(80,15);
			name.setLocation(20, 10);
			this.add(name);
			repaint();
		}
	}
}
