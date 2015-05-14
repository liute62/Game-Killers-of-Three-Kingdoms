package com.gui.gaming;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.logic.player.APlayer;
import com.system.constants.GUIConst;
import com.system.utils.DebugUtil;
import com.system.utils.ResUtil;

public class DeckProfilePanel extends JPanel{

	private static final long serialVersionUID = -2029866497979448042L;

	APlayer player;
	HPPanel hpPanel;
	SkillPanel skillPanel;
	JLabel character;
	int maxHp;
	BufferedImage profile;
	BufferedImage skillBg;
	BufferedImage health;
	
	public DeckProfilePanel(int maxHp,APlayer player){
		this.player = player;
		this.maxHp = maxHp;
		this.setLayout(null);
		resInitial();
		setCharacterPanel();
		setSkillPanel();
        setHPPanel();
	}
	
	private void resInitial(){
		profile = player.getProfile();
		profile = profile.getSubimage(0, 0, profile.getWidth(), profile.getHeight());
		health = player.getHealthBar();
		skillBg = ResUtil.getImgByName("bg_skill", 1);
	}
	
	private void setHPPanel(){
		hpPanel = new HPPanel();
		this.add(hpPanel);
		hpPanel.setLocation(0, 0);
	}
	
	private void setCharacterPanel(){
		character = new JLabel("character");
		this.add(character);
		character.setSize(35, 50);
		//character.setLocation(hpPanel.getX()-character.getWidth(), 8);
	}
	
	private void setSkillPanel(){
		skillPanel = new SkillPanel();
		this.add(skillPanel);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(profile, 0, 0, this.getWidth(), this.getHeight(),null);
	}
	
	class HPPanel extends JPanel{
		
		private static final long serialVersionUID = -6792954420292239728L;
        int num;
        JLabel hp;

		public HPPanel(){
			DebugUtil.print();
            num = player.getCurrentHP();
            hp = new JLabel(String.valueOf(num));
            this.setBackground(new Color(0, 0, 0));
			this.setOpaque(true);
			this.setSize(GUIConst.HPPanelWidth	,GUIConst.HPPanelHeight);
            this.add(hp);
            hp.setFont(new Font(Font.DIALOG, Font.BOLD, 21));
            hp.setForeground(Color.white);
		}
//
//		@Override
//		public void paint(Graphics g) {
//			// TODO Auto-generated method stub
//			super.paint(g);
//			g.drawImage(health, 0, 0, this.getWidth(), this.getHeight(),null);
//		}
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
			for (int i = 0; i < 2; i++) {
				add(new SKillBtn(String.valueOf(i)));
			}
		}
		
		class SKillBtn extends JPanel{
			
		private static final long serialVersionUID = 3569271486968472594L;

			public SKillBtn(String name){
				this.setSize(100, 50);
				Font f = new Font("Arial", Font.BOLD, 22);
				text.setFont(f);
				text.setText(name);
				//text.setOpaque(false);
				this.add(text);
			}
			
			@Override
			public void paint(Graphics g) {
					// TODO Auto-generated method stub
					super.paint(g);
					g.drawImage(skillBg, 0, 0, this.getWidth(), this.getHeight(),null);
				}
		}
	}
	
}
