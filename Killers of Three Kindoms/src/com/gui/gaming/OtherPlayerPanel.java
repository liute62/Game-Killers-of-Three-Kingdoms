package com.gui.gaming;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.naming.InitialContext;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.logic.player.APlayer;
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
	APlayer player;
	private boolean isSelected;
	JLabel name;
	JLabel HP;
	DeckEquipmentPanel equipmentPanel;
	CardNumPanel cardNumPanel;
	
	public OtherPlayerPanel(APlayer player){
		this.player = player;
		isSelected = false;
		this.setSize(GUIConst.otherPlayerPanelWidth, GUIConst.otherPlayerPanelHeight);
		this.setLayout(null);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBackground(Color.BLUE);
		addMouseListener(this);
		addEquipmentPanel();
		addProfilePanel();
		addCardNumPanel();
	}
	
	private void addProfilePanel(){
		name = new JLabel("Name: "+player.getName());
		name.setForeground(Color.white);
		HP = new JLabel("HP: "+player.getCurrentHP());
		HP.setForeground(Color.white);
		this.add(name);
		this.add(HP);
		name.setSize(GUIConst.otherPlayerPanelWidth/2,GUIConst.otherPlayerPanelHeight/4);
		name.setLocation(18,0);
		HP.setSize(GUIConst.otherPlayerPanelWidth/2,GUIConst.otherPlayerPanelHeight/4);
		HP.setLocation(18, name.getLocation().y+GUIConst.otherPlayerPanelHeight/4);
	}
	
	private void addCardNumPanel(){
		cardNumPanel = new CardNumPanel();
		this.add(cardNumPanel);
	}
	
	private void addEquipmentPanel(){
		equipmentPanel = new DeckEquipmentPanel(player);
		equipmentPanel.setSize(getWidth()-35, getHeight()/2);
		equipmentPanel.setLocation(18, getHeight()/2-10);
		this.add(equipmentPanel);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
	class CardNumPanel extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4877609870333971466L;
		int num;
		JLabel jl;

		public CardNumPanel() {
			num = player.getHands().size();
			jl = new JLabel(String.valueOf(num));
			this.setSize(20, 30);
			this.setLocation(0, GUIConst.otherPlayerPanelHeight-this.getHeight());
			this.add(jl);
			jl.setFont(new Font(Font.DIALOG, Font.BOLD, 21));
			jl.setForeground(Color.RED);
		}

		public void paint(Graphics g) {
			// 更新手牌数
			num = player.getHands().size();
			jl.setText(String.valueOf(num));
			super.paintChildren(g);
		}
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
