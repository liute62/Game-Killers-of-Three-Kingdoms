package com.gui.gaming;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.system.constants.GUIConst;

public class BattleFieldPanel extends JPanel{

	private static final long serialVersionUID = 4789443358971328437L;
	private static BattleFieldPanel instance;
	
	private BattleFieldPanel(){
		instance = this;
		this.setLayout(null);
		this.setOpaque(false);
		this.setSize(GUIConst.mainFrameWidth/5*3,GUIConst.playerPanelWidth+20);
		this.setLocation(GUIConst.mainFrameWidth/5, GUIConst.playerPanelHeight+40);
		JButton jButton = new JButton("BattleFieldPanel");
		this.add(jButton);
	}
	
	public static BattleFieldPanel getInstance() {
		if(instance==null){
			instance = new BattleFieldPanel(); 
		}
		return instance;
	}
}
