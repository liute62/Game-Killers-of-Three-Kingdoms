package com.gui.gaming;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.management.InstanceAlreadyExistsException;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.card.interfaces.ACard;
import com.gui.gaming.DeckHandCardPanel.BtnPanel;
import com.logic.player.APlayer;
import com.system.constants.GUIConst;
import com.system.utils.DebugUtil;
import com.system.utils.ResUtil;

/**
 * This is a panel for card casted or dropped.
 * @author liuh4
 *
 */
public class BattleFieldPanel extends JPanel{

	private static BattleFieldPanel instance;
	private static final long serialVersionUID = 4789443358971328437L;
	private	List<CardPanel> cardPanels;
	private List<ACard> cards;
	
	public static BattleFieldPanel Instance() {
		if(instance == null){
			instance = new BattleFieldPanel();
		}
		return instance;
	}
	
	private BattleFieldPanel(){
		instance = this;
		this.setOpaque(false);
		this.setLayout(null);
		this.setSize(GUIConst.mainFrameWidth/5*3,GUIConst.playerPanelWidth+20);
		this.setLocation(GUIConst.mainFrameWidth/5, GUIConst.playerPanelHeight);
		initial();
	}
	
	private void initial(){
		cardPanels = new ArrayList<CardPanel>();
		cards = new ArrayList<>();
	}
	
	public void addAcard(ACard card) {
		cards.add(card);
		int i = cards.size() - 1;
		CardPanel cardPanel = new CardPanel(card);
		cardPanel.setSelectable(false);
		cardPanel.setUsed(true);
		this.add(cardPanel);
		cardPanel.setLocation(cardPanel.getWidth()*i, 20);
		repaint();
	}
	
	public void addACard(APlayer player,ACard card){
        System.out.println("PLAYER: " + player.getTargetPlayer());
        try {
            MessagePanel.Instance().addAMessage(player.getName()+" cast "+card.getName()+" card to "+player.getTargetPlayer().getName()+".");
        } catch (RuntimeException e) {
            System.out.println("NULL PLAYER");
        }
		cards.add(card);
		int i = cards.size() - 1;
		CardPanel cardPanel = new CardPanel(card);
		cardPanel.setSelectable(false);
		cardPanel.setUsed(true);
		this.add(cardPanel);
		cardPanel.setLocation(cardPanel.getWidth()*i, 20);
		repaint();
	}
	
	public void addNoneTargetACard(APlayer player, ACard card) {
		// TODO Auto-generated method stub
		try {
			 MessagePanel.Instance().addAMessage(player.getName() + " uses " + card.getName() +  ".");
        } catch (RuntimeException e) {
            System.out.println("NULL PLAYER");
        }
		cards.add(card);
		int i = cards.size() - 1;
		CardPanel cardPanel = new CardPanel(card);
		cardPanel.setSelectable(false);
		cardPanel.setUsed(true);
		this.add(cardPanel);
		cardPanel.setLocation(cardPanel.getWidth()*i, 20);
		repaint();
	}
	
	public void addADiscard(APlayer player,ACard card){
		MessagePanel.Instance().addAMessage(player.getName()+" dicard "+card.getName()+".");
		cards.add(card);	
		int i = cards.size() - 1;
		CardPanel cardPanel = new CardPanel(card);
		cardPanel.setSelectable(false);
		cardPanel.setUsed(true);
		this.add(cardPanel);
		cardPanel.setLocation(cardPanel.getWidth()*i, 20);
		repaint();
	}
	
	public void clear(){
		cards.clear();
		this.removeAll();
		repaint();
	}

	
}
