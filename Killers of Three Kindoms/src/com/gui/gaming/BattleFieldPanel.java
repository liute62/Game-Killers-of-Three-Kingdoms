package com.gui.gaming;


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
		this.setLayout(null);
		this.setOpaque(false);
		this.setSize(GUIConst.mainFrameWidth/5*3,GUIConst.playerPanelWidth+20);
		this.setLocation(GUIConst.mainFrameWidth/5, GUIConst.playerPanelHeight);
		initial();
	}
	
	private void initial(){
		cardPanels = new ArrayList<CardPanel>();
		cards = new ArrayList<>();
	}
	
	public void addACard(APlayer player,ACard card){
		MessagePanel.Instance().addAMessage(player.getName()+" cast "+card.getName()+" card.");
		cards.add(card);	
		int i = cards.size() - 1;
		CardPanel cardPanel = new CardPanel(card);
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
