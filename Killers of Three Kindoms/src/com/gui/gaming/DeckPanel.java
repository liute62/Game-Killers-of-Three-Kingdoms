package com.gui.gaming;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.system.constants.GUIConst;

public class DeckPanel extends JPanel{
	

	private static final long serialVersionUID = 8244929675740650403L;

	private DeckEquipmentPanel deckEquipmentPanel;
	private DeckHandCardPanel deckHandCardPanel;
	private DeckProfilePanel deckProfilePanel;
	
	public DeckPanel(){
		initial();
		this.setLayout(null);
		this.setSize(GUIConst.mainFrameWidth,GUIConst.mainFrameHeight/3-30);
		this.setLocation(0, GUIConst.mainFrameHeight-this.getHeight()-30);	
		this.setBackground(Color.BLACK);
		setEquipmentPanel();
		setDeckHandCardPanel();
		setDeckProfilePanel();
	}
	
	private void initial(){
		deckEquipmentPanel = new DeckEquipmentPanel();
		deckHandCardPanel = new DeckHandCardPanel();
		deckProfilePanel = new DeckProfilePanel();
	}
	
	private void setEquipmentPanel(){
		this.add(deckEquipmentPanel);
		deckEquipmentPanel.setSize(GUIConst.mainFrameWidth/6-20,this.getHeight()-50);
		deckEquipmentPanel.setLocation(20, 25);
	}
	
	private void setDeckHandCardPanel(){
		this.add(deckHandCardPanel);
	}
	
	private void setDeckProfilePanel(){
		this.add(deckProfilePanel);
		deckProfilePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		deckProfilePanel.setSize(this.getWidth()/5,this.getHeight());
		deckProfilePanel.setLocation(GUIConst.mainFrameWidth - deckProfilePanel.getWidth()-10, 0);
	}
}
