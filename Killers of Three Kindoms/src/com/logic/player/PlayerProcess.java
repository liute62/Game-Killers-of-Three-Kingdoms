package com.logic.player;

import com.gui.gaming.BattleFieldPanel;
import com.gui.gaming.MessagePanel;
import com.system.enums.GameState;

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
		
	}
	
	private void stage_begin(){
		player.gameState = GameState.begin;
		BattleFieldPanel.Instance().clear();
		MessagePanel.Instance().addAMessage(player.getName() + "begin");
	}
	
	private void stage_check(){
		player.gameState = GameState.check;
		BattleFieldPanel.Instance().clear();
		MessagePanel.Instance().addAMessage(player.getName()+"check");
		
	}
	
	private void stage_drawcard(){
		player.gameState = GameState.drawCard;
		BattleFieldPanel.Instance().clear();
		MessagePanel.Instance().addAMessage(player.getName()+"drawCard");
		player.drawACard();
		player.drawACard();
	}
	
	private void stage_castcard(){
		player.gameState = GameState.castCard;
	}
	
	private void stage_discard(){
		player.gameState = GameState.dropCard;
	}
	
	private void stage_end(){
		player.gameState = GameState.end;
	}
	
	private void nextPlayer(){
		player.getNextPlayer().playerProcess();	
	}
}
