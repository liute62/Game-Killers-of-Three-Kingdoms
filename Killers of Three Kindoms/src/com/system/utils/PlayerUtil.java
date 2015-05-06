package com.system.utils;

import java.util.ArrayList;
import java.util.List;

import com.gui.gaming.OtherPlayerPanel;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.enums.HeroName;

public class PlayerUtil {

	private static PlayerUtil instance = null;
	private APlayer player;
	private List<APlayer> players;
	private List<OtherPlayerPanel> playerPanels;
	private APlayer targertPlayer;
	
	private PlayerUtil() {
		instance = this;
		setPlayers(playerInitial());
		setPlayer(getPlayers().get(0));
	}
	
	public static PlayerUtil getInstance() {
		if (instance == null) {
			return new PlayerUtil();
		}
		return instance;
	}
	
	private List<APlayer> playerInitial(){
		List<APlayer> data = new ArrayList<APlayer>();
		APlayer player1 = new Player(false,0);
		APlayer player2 = new Player(true,1);
		APlayer player3 = new Player(true,2);
		APlayer player4 = new Player(true,3);
		APlayer player5 = new Player(true,4);
		data.add(player1);
		data.add(player2);
		data.add(player3);
		data.add(player4);
		data.add(player5);
		initPos(data);
		initInfo(data);
		return data;
	}
	
	private void initPos(List<APlayer> players){
		for (int i = 0; i < players.size(); i++) {
			players.get(i).setPosition(i+1);
			int tmp = i+1;
			if (tmp > players.size() - 1) {
				tmp = 0;
			}
			players.get(i).setNextPlayer(players.get(tmp));
		}
	}
	
	private void initInfo(List<APlayer> players){
		players.get(0).setName(HeroName.ZhaoYun);
		players.get(1).setName(HeroName.GuanYu);
		players.get(2).setName(HeroName.CaoCao);
		players.get(3).setName(HeroName.GuoJia);
		players.get(4).setName(HeroName.ZhangLiao);
	}
	
    /**
     * Calculate the distance between two player.
     * 1. clockwise direction;
     * 2. anticlockwise direction;
     * get the minimum distance between the two direction.
     * If player1 has a MinusMountCard, the distance will be reduced;
     * If player2 has a PlusMountCard, the distance will be increased.
     *
     * @param player1
     * @param player2
     * @return distance between two player.
     * @throws java.lang.RuntimeException if distance is not valid.
     */
    public int getDistance(APlayer player1, APlayer player2) {
        if (player1.getPosition() < 1 || player2.getPosition() < 1 ||
            player1.getPosition() > 5 || player2.getPosition() > 5) {
            throw new RuntimeException("Invalid distance.");
        }
        int distance = Math.abs(player2.getPosition() - player1.getPosition());
        if (distance > 2) {
            distance = 5 - distance;
        }
        if (player1.getMinusMount() != null) {
            distance -= player1.getMinusMount().getAffectedRange();
        }
        if (player2.getPlusMount() != null) {
            distance += player2.getPlusMount().getAffectedRange();
        }
        return distance;
    }

	public List<APlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<APlayer> players) {
		this.players = players;
	}

	public APlayer getPlayer() {
		return player;
	}

	public void setPlayer(APlayer player) {
		this.player = player;
	}

	public List<OtherPlayerPanel> getPlayerPanels() {
		return playerPanels;
	}

	public void setPlayerPanels(List<OtherPlayerPanel> playerPanels) {
		this.playerPanels = playerPanels;
	}

	public APlayer getTargertPlayer() {
		return targertPlayer;
	}

	public void setTargertPlayer(APlayer targertPlayer) {
		this.targertPlayer = targertPlayer;
	}
}
