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
	BufferedImage bgWin;
	BufferedImage bgLost;
	private boolean isGameOver;
	private static MainPanel instance = null;
	
	public static MainPanel getTheInstance(){
		if (instance == null) {
			System.err.println("Main Panel instance == null");
		}
		return instance;
	}
	
	public MainPanel(APlayer player) {
		this.instance = this;
		this.setOpaque(true);
		this.player = player;
		this.isGameOver = false;
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
		if (isGameOver) {
			if (player.isDead()) {
				//that means the player has lose the game
				g.drawImage(bgLost, 0, 0, this.getWidth(), this
						.getHeight(), null);
			}else {
				g.drawImage(bgWin, 0, 0, this.getWidth(), this
						.getHeight(), null);
			}
			
		}else {
			g.drawImage(bgImg, 0, 0, this.getWidth(), this
					.getHeight(), null);	
		}
	}
	
	private void resIntial(){
		bgImg = ResUtil.getImgByName("bg2",0);
		bgExitImg = ResUtil.getImgByName("bg_exit", 1);
		bgWin = ResUtil.getImgByName("bg_win", 1);
		bgLost = ResUtil.getImgByName("bg_lost", 1);
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
	
	class ExitBtn extends JButton implements MouseListener{
		
		public ExitBtn(){
			this.setLocation(0, 0);
			this.setSize(120, 40);
			this.setBackground(Color.black);
			this.setText("Exit");
			this.setForeground(Color.white);
            this.addMouseListener(this);
		}
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(bgExitImg, 0, 0, this.getWidth(), this
					.getHeight(), null);
		}

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("xx");
             MainFrame.getInstance().removePanel(MainPanel.this);
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

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

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
		repaint();
	}
}
