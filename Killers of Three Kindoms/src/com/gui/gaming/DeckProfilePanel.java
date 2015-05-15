package com.gui.gaming;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hero.skills.interfaces.ISkill;
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
	BufferedImage health;
    BufferedImage skillBg;
    BufferedImage skillHighlightBg;
    BufferedImage skillGrayBg;

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
        skillHighlightBg = ResUtil.getImgByName("bg_skill_highlight", 1);
        skillGrayBg = ResUtil.getImgByName("bg_skill_gray", 1);
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
		super.paint(g);
		g.drawImage(profile, 0, 0, this.getWidth(), this.getHeight(),null);
	}

    public void updateHP() {
        hpPanel.updateNum(false);
    }

	class HPPanel extends JPanel{
		
		private static final long serialVersionUID = -6792954420292239728L;
        int num;
        JLabel hp;

		public HPPanel(){
            updateNum(true);
		}

        public void updateNum(boolean isInit) {
            if (!isInit) {
                this.remove(hp);
            }
            num = player.getCurrentHP();
            hp = new JLabel(String.valueOf(num));
            this.setBackground(Color.black);
            this.setOpaque(true);
            this.setSize(GUIConst.HPPanelWidth	,GUIConst.HPPanelHeight);
            this.add(hp);
            hp.setFont(new Font(Font.DIALOG, Font.BOLD, 21));
            hp.setForeground(Color.white);
        }
	}
	
	class SkillPanel extends JPanel{
		
		private static final long serialVersionUID = -8117196945630496225L;
		private SKillBtn button;

		public SkillPanel() {
			this.setLocation(20, 150);
            this.setSize(72, 50);
            this.setBackground(new Color(0, 0, 0, 0));
            button = new SKillBtn();
            this.add(button);
		}
		
		class SKillBtn extends JPanel{
			
		    private static final long serialVersionUID = 3569271486968472594L;
            private MouseListener listener;
            int skillStatus = 0; // 0: no skills; 1: skill ready; 2: skill not available

			public SKillBtn(){
                this.setLocation(0, 0);
                this.setOpaque(false);
                this.setSize(72, 45);
                this.setPreferredSize(new Dimension(72, 45));
                this.setCursor(new Cursor(Cursor.HAND_CURSOR));
                this.setLayout(null);
                this.setBackground(new Color(0, 0, 0, 0));
                listener = new SkillListener();
                this.addMouseListener(listener);
			}
			
			@Override
			public void paint(Graphics g) {
                super.paint(g);
                if (skillStatus == 0) {
                    g.drawImage(skillBg, 0, 0, 72, 45, null);
                } else if (skillStatus == 1) {
                    g.drawImage(skillHighlightBg, 0, 0, 72, 45, null);
                } else if (skillStatus == 2) {
                    g.drawImage(skillGrayBg, 0, 0, 72, 45, null);
                }
            }

            class MyClick extends MouseAdapter {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    DebugUtil.print("mousePressed");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                }

                private void clicked() {

                }
            }

            class SkillListener extends MyClick {
                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    if (skillStatus == 1) {
                        // TODO: Cast skill here.
                        ISkill skill = player.getSkill();
                        MessagePanel.Instance().addAMessage("Trying to cast spell: " + skill.getClass().getName());
                    }
                }
            }
        }

	}

    public void setSkillStatus(int skillStatus) {
        this.skillPanel.button.skillStatus = skillStatus;
        this.skillPanel.button.repaint();
    }

    public SkillPanel getSkillPanel() {
        return skillPanel;
    }
}
