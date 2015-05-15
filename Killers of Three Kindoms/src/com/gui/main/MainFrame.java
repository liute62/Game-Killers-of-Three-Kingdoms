package com.gui.main;

import java.util.List;

import javax.swing.JFrame;

import com.gui.gaming.MessagePanel;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.constants.GUIConst;
import com.system.enums.RoleType;
import com.system.utils.DebugUtil;
import com.system.utils.PlayerUtil;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = -6060174194003158327L;
	private static MainFrame instance;
	private SelectHeroPanel selectHeroPanel;
	private MainPanel mainPanel;
	private static GameThread gt;
	private APlayer firstPlayer;
	public static MainFrame getInstance(){
		if(instance == null){
			return new MainFrame();
		}else {
			return instance;
		}
	}
	
	private MainFrame(){
		instance = this;
		createSelectUI();
		createUI();
	}
	
	/**
	 * select character panel
	 */
	private void createSelectUI(){
		selectHeroPanel = new SelectHeroPanel();
	}
	
	private void createUI() {
		this.setTitle(GUIConst.mainFrameTitle);
		this.setSize(GUIConst.mainFrameWidth, GUIConst.mainFrameHeight);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.add(selectHeroPanel);
		//Main.isFinished = true;
		this.setVisible(true);	
	}
	
	public void loadHeroSelect(){
		this.remove(mainPanel);
		createSelectUI();
		createUI();
	}
	
	public void loadMain(){
		DebugUtil.print("loadMain");
		this.remove(selectHeroPanel);
		repaint();
		createPlayer();
		mainPanel = new MainPanel(firstPlayer);
		add(mainPanel);
		startThread();
	}
	
	public void startThread(){
		gt = new GameThread();
		gt.start();
	}
	
	/**
	 * Game Main Thread
	 */
	class GameThread extends Thread {
		public void run() {
			startGame();
		}
	}
	
	public void startGame() {
		firstPlayer.playerProcess();
	}
	
	private void createPlayer(){
		firstPlayer = PlayerUtil.getInstance().getPlayer();
	}
}
