package com.gui.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.gui.gaming.BattleFieldPanel;
import com.gui.gaming.MessagePanel;
import com.system.constants.GUIConst;
import com.system.constants.MainConst;
import com.system.utils.PlayerUtil;
import com.system.utils.ResUtil;
import com.gui.gaming.*;
import com.logic.player.APlayer;

public class MainPanel extends JPanel{


	APlayer player;
	private static final long serialVersionUID = 214504522875008913L;
	DeckPanel deckPanel;
	BattleFieldPanel battleFieldPanel;
	List<OtherPlayerPanel> otherPlayerPanels;
	ExitBtn exitBtn;
	private MessagePanel messagePanel;
	BufferedImage bgImg;
	BufferedImage bgExitImg;
	
	public MainPanel(APlayer player) {
		this.player = player;
		resIntial();
		initial();
		this.setSize(GUIConst.mainPanelWidth,GUIConst.mainPanelHeight);
		this.setLocation(0,0);
		this.setLayout(null);
		setExitBtn();
		this.add(deckPanel);
		for (int i = 0; i < MainConst.gamePlayerNum-1; i++) {
			OtherPlayerPanel pp = new OtherPlayerPanel(PlayerUtil.getInstance().getPlayers().get(i+1));
			otherPlayerPanels.add(pp);
			this.add(otherPlayerPanels.get(i));
		}
		setPanelPosition();
		PlayerUtil.getInstance().setPlayerPanels(otherPlayerPanels);
		this.add(battleFieldPanel);
		setMessagePanel();
		validate();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawImage(bgImg, 0, 0, this.getWidth(), this
				.getHeight(), null);
	}
	private void resIntial(){
		bgImg = ResUtil.getImgByName("bg2",0);
		bgExitImg = ResUtil.getImgByName("bg_exit", 1);
	}
	
	private void initial(){
		exitBtn = new ExitBtn();
		battleFieldPanel = BattleFieldPanel.Instance();
		otherPlayerPanels = new ArrayList<OtherPlayerPanel>();
		deckPanel = new DeckPanel(player);
	}
	
	private void setMessagePanel(){
		messagePanel = new MessagePanel();
		this.add(messagePanel);
		messagePanel.setLocation(800,0);
	}
	
	class ExitBtn extends JButton{
		
		public ExitBtn(){
			this.setLocation(0, 0);
			this.setSize(120, 40);
			this.setBackground(Color.black);
			this.setText("Exit");
			this.setForeground(Color.white);
		}
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(bgExitImg, 0, 0, this.getWidth(), this
					.getHeight(), null);
		}
	}
	private void setExitBtn(){
		this.add(exitBtn);
		
	}
	
	private void setPanelPosition(){
		if(otherPlayerPanels.get(3)!=null)otherPlayerPanels.get(3).setLocation(0, 230);
		if(otherPlayerPanels.get(2)!=null)otherPlayerPanels.get(2).setLocation(GUIConst.mainFrameWidth/5*1, 0);
		if(otherPlayerPanels.get(1)!=null)otherPlayerPanels.get(1).setLocation(GUIConst.mainFrameWidth/5*2, 0);
		if(otherPlayerPanels.get(0)!=null)otherPlayerPanels.get(0).setLocation(GUIConst.mainFrameWidth/5*3, 0);
	}
}
