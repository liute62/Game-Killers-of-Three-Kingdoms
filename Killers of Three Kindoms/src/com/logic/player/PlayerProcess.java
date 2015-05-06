package com.logic.player;

import javax.swing.DebugGraphics;

import com.ai.service.AIAction;
import com.gui.gaming.BattleFieldPanel;
import com.gui.gaming.MessagePanel;
import com.system.enums.GameStage;
import com.system.utils.DebugUtil;

public class PlayerProcess {

	APlayer player;
	
	public PlayerProcess(APlayer player){
		this.player = player;
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
		nextPlayer();
	}
	
	private void init(){
		if (player.isAI()) {
			
		}else {
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
		player.drawACard();
		player.drawACard();
		//refresh
	}
	
	private void stage_castcard(){
		player.gameStage = GameStage.castCard;
		//if is a AI
		if (player.isAI()) {
			new AIAction(player).castCard();
			return ;
		}
		//if is player
		MessagePanel.Instance().addAMessage(player.getName()+" castCard stage");
		//DebugUtil.print("castcard player id:"+player.getId());
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
			//DebugUtil.print(player.isSkipped());
		}
	}
	
	private void stage_discard(){
		player.gameStage = GameStage.discard;
		MessagePanel.Instance().addAMessage(player.getName()+" discard stage");
		if (player.isAI()) {
			new AIAction(player).dropCard();
			return ;
		}
	}
	
	private void stage_end(){
		player.gameStage = GameStage.end;
		MessagePanel.Instance().addAMessage(player.getName()+" end stage",1);
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
