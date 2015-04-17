package com.gui.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.gui.gaming.BattleFieldPanel;
import com.gui.gaming.MessagePanel;
import com.system.constants.GUIConst;
import com.system.constants.MainConst;
import com.gui.gaming.*;

public class MainPanel extends JPanel{


	private static final long serialVersionUID = 214504522875008913L;
	DeckPanel deckPanel;
	BattleFieldPanel battleFieldPanel;
	List<OtherPlayerPanel> otherPlayerPanels;
	JButton exitBtn;
	private MessagePanel messagePanel;
	
	
	public MainPanel() {
		initial();
		this.setSize(GUIConst.mainPanelWidth,GUIConst.mainPanelHeight);
		this.setLocation(0,0);
		this.setLayout(null);
		setExitBtn();
		this.add(deckPanel);
		for (int i = 0; i < MainConst.gamePlayerNum-1; i++) {
			OtherPlayerPanel pp = new OtherPlayerPanel();
			otherPlayerPanels.add(pp);
			this.add(otherPlayerPanels.get(i));
		}
		setPanelPosition();
		this.add(battleFieldPanel);
		setMessagePanel();
		validate();
	}
	
	private void initial(){
		exitBtn = new JButton("Exit");
		battleFieldPanel = BattleFieldPanel.Instance();
		otherPlayerPanels = new ArrayList<OtherPlayerPanel>();
		deckPanel = new DeckPanel();
	}
	
	private void setMessagePanel(){
		messagePanel = new MessagePanel();
		this.add(messagePanel);
		messagePanel.setLocation(800,0);
	}
	
	private void setExitBtn(){
		this.add(exitBtn);
		exitBtn.setLocation(0, 0);
		exitBtn.setSize(120, 40);
		exitBtn.addMouseListener(new MouseListener() {
			
	
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				MainFrame.getInstance().loadHeroSelect();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void setPanelPosition(){
		if(otherPlayerPanels.get(3)!=null)otherPlayerPanels.get(3).setLocation(0, 230);
		if(otherPlayerPanels.get(2)!=null)otherPlayerPanels.get(2).setLocation(GUIConst.mainFrameWidth/5*1, 0);
		if(otherPlayerPanels.get(1)!=null)otherPlayerPanels.get(1).setLocation(GUIConst.mainFrameWidth/5*2, 0);
		if(otherPlayerPanels.get(0)!=null)otherPlayerPanels.get(0).setLocation(GUIConst.mainFrameWidth/5*3, 0);
	}
}
