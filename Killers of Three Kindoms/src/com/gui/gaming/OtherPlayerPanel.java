package com.gui.gaming;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.nio.channels.SelectableChannel;
import java.util.List;

import javax.naming.InitialContext;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.hamcrest.CoreMatchers;

import com.logic.player.APlayer;
import com.system.constants.GUIConst;
import com.system.utils.DebugUtil;
import com.system.utils.PlayerUtil;
import com.system.utils.ResUtil;

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
	private boolean isTarget;
	private boolean isDoing;
	JLabel name;
	JLabel HP;
	DeckEquipmentPanel equipmentPanel;
	CardNumPanel cardNumPanel;
	HpNumPanel hpNumPanel;
	BufferedImage img1;
	BufferedImage img2;
	BufferedImage bg;
	BufferedImage isDoingBg;

	public OtherPlayerPanel(APlayer player){
		this.player = player;
		this.player.setOtherPlayerPanel(this);
		isSelected = false;
		isTarget = false;
		isDoing = false;
		this.setOpaque(false);
		this.setSize(GUIConst.otherPlayerPanelWidth, GUIConst.otherPlayerPanelHeight);
		this.setLayout(null);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		resInitial();
		addMouseListener(this);
		addEquipmentPanel();
		//addProfilePanel();
		addCardNumPanel();
		addHpNumPanel();
	}

	private void resInitial(){
		img1 = player.getProfile();
		img2 = img1.getSubimage(0, 0, img1.getWidth(), img1.getHeight());
		bg = ResUtil.getImgByName("bg_profile", 1);
		isDoingBg = ResUtil.getImgByName("bg_doing", 1);
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

	private void addHpNumPanel(){
		hpNumPanel = new HpNumPanel();
		this.add(hpNumPanel);
	}

	private void addEquipmentPanel(){
		equipmentPanel = new DeckEquipmentPanel(player);
		equipmentPanel.setSize(getWidth()-35, getHeight()/2);
		equipmentPanel.setLocation(18, getHeight()/2-10);
		equipmentPanel.setOpaque(true);
		this.add(equipmentPanel);
	}

	public void select(){
		List<OtherPlayerPanel> tmp = PlayerUtil.getInstance().getPlayerPanels();
		for (int i = 0; i < tmp.size(); i++) {
			tmp.get(i).unselect();
		}
		//this.setBackground(Color.red);
		isSelected = true;
		PlayerUtil.getInstance().setTargertPlayer(this.player);
	}

	public void unselect(){
		//this.setBackground(Color.BLUE);
		isSelected = false;
		PlayerUtil.getInstance().setTargertPlayer(null);
	}

	public void target(){
		this.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		isTarget = true;
	}

	public void untarget(){
		isTarget = false;
	}

	public void unBorder(){
		//this.setBorder(BorderFactory.createLineBorder(Color.blue));
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img2, 0, 0, this.getWidth(), this.getHeight(),null);
		g.drawImage(bg, -10, -10, this.getWidth()+20, this.getHeight()+20,null);

		if (isDoing) {
			g.drawImage(isDoingBg, -10, -10, this.getWidth()+10, this.getHeight()+10,null);
		}
		super.paintChildren(g);
		//g.dispose();
	}

    public void updateHP() {
        hpNumPanel.updateNum(false);
    }

	class HpNumPanel extends JPanel{

		private static final long serialVersionUID = -4430152870990297723L;
		int num;
        JLabel hp;

		public HpNumPanel() {
            updateNum(true);
		}

		public void updateNum(boolean isInit) {
            if (!isInit) {
                this.remove(hp);
            }
            num = player.getCurrentHP();
            hp = new JLabel(String.valueOf(num));
            this.setSize(20, 30);
            this.setLocation(0, 0);
            this.add(hp);
            this.setBackground(Color.black);
            this.setOpaque(true);
            hp.setFont(new Font(Font.DIALOG, Font.BOLD, 21));
            hp.setForeground(Color.white);
        }
	}

    public void updateCardNum() {
        cardNumPanel.updateNum(false);
    }

	class CardNumPanel extends JPanel {

		/**
		 *
		 */
		private static final long serialVersionUID = -4877609870333971466L;
		int num;
		JLabel jl;

		public CardNumPanel() {
            updateNum(true);
		}

        public void updateNum(boolean isInit) {
            if (!isInit) {
                this.remove(jl);
            }
            num = player.getHands().size();
            jl = new JLabel(String.valueOf(num));
            this.setSize(20, 30);
            this.setOpaque(true);
            this.setLocation(0, GUIConst.otherPlayerPanelHeight - this.getHeight());
            this.add(jl);
            jl.setFont(new Font(Font.DIALOG, Font.BOLD, 21));
            jl.setForeground(Color.RED);
        }

		public void paint(Graphics g) {
			num = player.getHands().size();
			jl.setText(String.valueOf(num));
			super.paintChildren(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub\
		if (isTarget) {
			if(isSelected){
				unselect();
			}else {
				select();
			}
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

	public boolean isDoing() {
		return isDoing;
	}

	public void setDoing(boolean isDoing) {
		this.isDoing = isDoing;
		repaint();
	}


}
