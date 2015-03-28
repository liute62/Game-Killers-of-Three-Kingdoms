package com.gui.main;

import javax.swing.JFrame;
import com.system.constants.GUIConst;
import com.system.utils.DebugUtil;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = -6060174194003158327L;
	private static MainFrame instance;
	private SelectHeroPanel selectHeroPanel;
	private MainPanel mainPanel;
	private static GameThread gt;

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
		mainPanel = new MainPanel();
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
		
	}
}
