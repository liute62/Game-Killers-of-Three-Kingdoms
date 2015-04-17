package com.gui.gaming;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.system.constants.GUIConst;

public class DeckProfilePanel extends JPanel{

	private static final long serialVersionUID = -2029866497979448042L;

	HPPanel hpPanel;
	SkillPanel skillPanel;
	JLabel[] hps ;
	JLabel character;
	int maxHp;
	public DeckProfilePanel(int maxHp){
		this.maxHp = maxHp;
		this.setLayout(null);
		initial();
		setHPPanel();
		setCharacterPanel();
		setSkillPanel();
	}
	
	private void initial(){
		hpPanel = new HPPanel(5);
		for (int i = 0; i < maxHp; i++) {
			hps[i] = new JLabel(String.valueOf(i));
			hps[i].setForeground(Color.BLACK);
			this.add(hps[i]);
		}
	}
	
	private void setHPPanel(){
		this.add(hpPanel);
		hpPanel.setLocation(GUIConst.mainFrameWidth/5-hpPanel.getWidth(), 25);
		
	}
	
	private void setCharacterPanel(){
		character = new JLabel("character");
		this.add(character);
		character.setSize(35, 50);
		character.setLocation(hpPanel.getX()-character.getWidth(), 8);
	}
	
	private void setSkillPanel(){
		skillPanel = new SkillPanel();
		this.add(skillPanel);
	}
	
	class HPPanel extends JPanel{
		
		private static final long serialVersionUID = -6792954420292239728L;

		public HPPanel(int maxHp){
			hps = new JLabel[maxHp];
			this.setOpaque(true);
			this.setSize(GUIConst.HPPanelWidth	,GUIConst.HPPanelHeight);
			this.setLayout(new GridLayout(5,1));
		}
	}
	
	class SkillPanel extends JPanel{
		
		private static final long serialVersionUID = -8117196945630496225L;
		JLabel text = new JLabel();
		String name;
		public SkillPanel() {
			this.setSize(170, 40);
			this.setLayout(new GridLayout(0, 3));
			this.setLocation(20, 150);
			initial();
		}
		
		private void initial(){
			for (int i = 0; i < 3; i++) {
				add(new SKillBtn(String.valueOf(i)));
			}
		}
		
		class SKillBtn extends JButton{
			
		private static final long serialVersionUID = 3569271486968472594L;

			public SKillBtn(String name){
				this.setSize(100, 50);
				this.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Font f = new Font("Arial", Font.BOLD, 22);
				text.setFont(f);
				text.setForeground(Color.white);
				text.setText(name);
				this.add(text);
			}
		}
	}
	
}
