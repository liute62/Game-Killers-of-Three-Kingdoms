package com.gui.gaming;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;

import com.system.constants.GUIConst;

/**
 * Other player's panel
 * @author liuh4
 *
 */
public class OtherPlayerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3399450628324751951L;

	public OtherPlayerPanel(){
		this.setSize(GUIConst.otherPlayerPanelWidth, GUIConst.otherPlayerPanelHeight);
		this.setLayout(null);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBackground(Color.BLUE);
		//this.setOpaque(false);
	}
}
