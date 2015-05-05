package com.gui.gaming;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.logic.player.APlayer;
import com.system.constants.GUIConst;
import com.system.utils.DebugUtil;

/**
 * This is the base parent panel.
 * @author liuh4
 *
 */
public class DeckPanel extends JPanel{
	

	APlayer player;
	private static final long serialVersionUID = 8244929675740650403L;
	private DeckEquipmentPanel deckEquipmentPanel;
	private DeckHandCardPanel deckHandCardPanel;
	private DeckProfilePanel deckProfilePanel;
	
	public DeckPanel(APlayer player){
		this.player = player;
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
		deckEquipmentPanel = new DeckEquipmentPanel(player);
		deckHandCardPanel = new DeckHandCardPanel(player);
		deckProfilePanel = new DeckProfilePanel(5);
	}
	
	private void setEquipmentPanel(){
		this.add(deckEquipmentPanel);
		deckEquipmentPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
		deckEquipmentPanel.setSize(GUIConst.mainFrameWidth/6-20,this.getHeight()-50);
		deckEquipmentPanel.setLocation(20, 25);
	}
	
	private void setDeckHandCardPanel(){
		this.add(deckHandCardPanel);
		deckHandCardPanel.setBorder(BorderFactory.createLineBorder(Color.green, 3));
		deckHandCardPanel.setSize(
				deckEquipmentPanel.getX()+this.getWidth()-deckEquipmentPanel.getWidth()
				-255,this.getHeight());
		deckHandCardPanel.setLocation(deckEquipmentPanel.getWidth()+20, 0);
		deckHandCardPanel.setOpaque(false);
	}
	
	private void setDeckProfilePanel(){
		this.add(deckProfilePanel);
		deckProfilePanel.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		deckProfilePanel.setSize(this.getWidth()/5,this.getHeight());
		deckProfilePanel.setLocation(GUIConst.mainFrameWidth - deckProfilePanel.getWidth()-10, 0);
	}
}
