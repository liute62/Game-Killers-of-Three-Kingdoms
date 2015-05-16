package com.logic.player;

import java.text.BreakIterator;
import java.util.List;

import com.ai.service.AIAction;
import com.gui.gaming.BattleFieldPanel;
import com.gui.gaming.DeckHandCardPanel;
import com.gui.gaming.MessagePanel;
import com.gui.main.MainPanel;
import com.system.enums.GameStage;
import com.system.enums.RoleType;
import com.system.utils.DebugUtil;
import com.system.utils.PlayerUtil;

public class PlayerProcess {

	APlayer player;
	
	public PlayerProcess(APlayer player){
		this.player = player;
	}
	
	boolean gameOver(){
		if (player.isAI() == false && player.isDead()) {
			player.gameStage = GameStage.gameOver;
			MainPanel.getTheInstance().setGameOver(true);
			return true;
		}
		return false;
	}
	
	public void start(){
		init();
		stage_begin();
		stage_check();
		stage_drawcard();
		stage_castcard();
		stage_discard();
		stage_end();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (gameOver()) {
			List<RoleType> roles = PlayerUtil.getInstance().getWinningRoles();
			String msg = "";
			for (RoleType role : roles) {
				msg += role.name()+" ";
			}
			MessagePanel.Instance().addAMessage(msg+" win!");
		}else {
			nextPlayer();			
		}
	}
	
	private void init(){
		if (player.isAI()) {
			player.getOtherPlayerPanel().setDoing(true);
		}else {
			//refresh
			player.setSkipped(false);
		}
	}
	
	private void stage_begin(){
		player.gameStage = GameStage.begin;
		BattleFieldPanel.Instance().clear();
		MessagePanel.Instance().addAMessage(player.getName() + " begin stage",1);
		//refresh
	}
	
	private void stage_check(){
		player.gameStage = GameStage.check;
		BattleFieldPanel.Instance().clear();
		MessagePanel.Instance().addAMessage(player.getName()+" check stage");
		//get the cards for check
		//check for delay skill
		//refresh
	}
	
	private void stage_drawcard(){
		player.gameStage = GameStage.drawCard;
		BattleFieldPanel.Instance().clear();
		MessagePanel.Instance().addAMessage(player.getName()+" drawCard stage");
		if (player.isAI()) {
			new AIAction(player).drawCard();
			return ;
		}
		player.drawACard();
		player.drawACard();
		player.getDeckHandCardPanel().refresh();
	}
	
	private void stage_castcard(){
        // TODO: Just for fun
        if (player.getDeckPanel() != null) {
            player.getDeckPanel().getDeckProfilePanel().setSkillStatus(1);
        }

		player.gameStage = GameStage.castCard;
		MessagePanel.Instance().addAMessage(player.getName()+" castCard stage");
		//if is a AI
		if (player.isAI()) {
			new AIAction(player).castCard();
			return ;
		}
		//if is player
		DeckHandCardPanel panel = player.getDeckHandCardPanel();
		panel.setSkipBtnClickable();
		panel.setDiscardStage(false);
		
		while(! player.isSkipped()){
            if (player.isCastingcard()) {
				//cast the card
				player.setCastingcard(false);
			}if (player.isUsingSkill()) {
				//using the hero skill
				player.setUsingSkill(false);
			}if (player.gameStage == GameStage.gameOver) {
                break;
			}
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
	private void stage_discard(){
//        TODO: Just for fun
        player.setCurrentHP(player.getCurrentHP() - 2);
        MessagePanel.Instance().addAMessage("Current HP: "+player.getCurrentHP());
        if (player.getDeckPanel() != null) {
            player.getDeckPanel().getDeckProfilePanel().setSkillStatus(2);
        }

        player.gameStage = GameStage.discard;
        MessagePanel.Instance().addAMessage(player.getName()+" discard stage");
        if (player.isAI()) {
            new AIAction(player).dropCard();
            return ;
        }
        DeckHandCardPanel panel = player.getDeckHandCardPanel();
        panel.setSkipBtnUnClikable();
        panel.setDiscardStage(true);
        //check discard how many cards.
        // new Thread(new ThrowCards(player)).start();
        while (true) {
        	if (gameOver()) {
				break;
			}
            if(player.getHands().size() <= player.getCurrentHP()){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

	}
	
	private void stage_end(){
		player.gameStage = GameStage.end;
		MessagePanel.Instance().addAMessage(player.getName()+" end stage",1);
		if (player.isAI()) {
			new AIAction(player).end();
			return ;
		}
	}
	
	private void nextPlayer(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BattleFieldPanel.Instance().clear();
		MessagePanel.Instance().clear();
		player.getNextPlayer().playerProcess();	
	}
}
