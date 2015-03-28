package com.gui.gaming;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DeckEquipmentPanel extends JPanel{


	private static final long serialVersionUID = -2232599134692339919L;

	public DeckEquipmentPanel(){
		this.setLayout(new GridLayout(4, 1));
		this.setBackground(Color.WHITE);
		DeckEquipmentSubPanel weapon = new DeckEquipmentSubPanel();
		DeckEquipmentSubPanel armor = new DeckEquipmentSubPanel();
		DeckEquipmentSubPanel horseAttact = new DeckEquipmentSubPanel();
		DeckEquipmentSubPanel horseDefend = new DeckEquipmentSubPanel();
		this.add(weapon);
		this.add(armor);
		this.add(horseAttact);
		this.add(horseDefend);
	}
	
	class DeckEquipmentSubPanel extends JPanel{
		
		private static final long serialVersionUID = -4080521922706576417L;
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
		public DeckEquipmentSubPanel(){
			this.setBorder(border);
		}
	}
}
