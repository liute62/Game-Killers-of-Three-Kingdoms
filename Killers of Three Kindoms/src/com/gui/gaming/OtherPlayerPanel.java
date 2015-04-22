package com.gui.gaming;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.naming.InitialContext;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.system.constants.GUIConst;
import com.system.utils.DebugUtil;

/**
 * Other player's panel
 * @author liuh4
 *
 */
public class OtherPlayerPanel extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3399450628324751951L;
	private boolean isSelected;
	JLabel name;
	JLabel HP;
	
	public OtherPlayerPanel(){
		isSelected = false;
		this.setSize(GUIConst.otherPlayerPanelWidth, GUIConst.otherPlayerPanelHeight);
		this.setLayout(null);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBackground(Color.BLUE);
		addMouseListener(this);
		initial();
		this.add(name);
		this.add(HP);
	}

	private void initial(){
		name = new JLabel("playerName");
		name.setForeground(Color.white);
		HP = new JLabel("HP: ");
		HP.setForeground(Color.white);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub\
		if(isSelected){
			this.setBackground(Color.BLUE);
			isSelected = false;
		}else {
			this.setBackground(Color.red);
			isSelected = true;
		}
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
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
