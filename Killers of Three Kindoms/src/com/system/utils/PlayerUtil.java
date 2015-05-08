package com.system.utils;

import java.util.*;

import com.gui.gaming.OtherPlayerPanel;
import com.hero.skills.ability.MaChao_Horsemanship;
import com.hero.skills.active.GuanYu_MasterOfWarfare;
import com.hero.skills.active.ZhaoYun_Courage;
import com.hero.skills.interfaces.ISkill;
import com.hero.skills.process.ZhenJi_Siren;
import com.hero.skills.trigger.CaoCao_Treachery;
import com.hero.skills.trigger.GuoJia_Talented;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.enums.HeroName;
import com.system.enums.Kingdoms;
import com.system.enums.RoleType;

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
		player1.setPosition(1);
		player2.setPosition(2);
		player3.setPosition(3);
		player4.setPosition(4);
		player5.setPosition(5);
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
        // Shuffle all heroes.
        ArrayList<HeroName> names = new ArrayList<>();
        names.addAll(Arrays.asList(HeroName.values()));
        Collections.shuffle(names, new Random(System.nanoTime()));

        ArrayList<RoleType> roles = new ArrayList<>();
        roles.addAll(Arrays.asList(RoleType.Minister, RoleType.Monarch, RoleType.Trun_coat,
                RoleType.Rebel, RoleType.Rebel));
        Collections.shuffle(roles, new Random(System.nanoTime()));

        // Get first five heroes and initialize accordingly.
        // Assume the first one (index 0) is the human player.
        initInfoHelper(players.get(0).issueId(), players.get(0), names.get(0), false, roles.get(0));
        initInfoHelper(players.get(1).issueId(), players.get(1), names.get(1), true, roles.get(1));
        initInfoHelper(players.get(2).issueId(), players.get(2), names.get(2), true, roles.get(2));
        initInfoHelper(players.get(3).issueId(), players.get(3), names.get(3), true, roles.get(3));
        initInfoHelper(players.get(4).issueId(), players.get(4), names.get(4), true, roles.get(4));
	}

    private void initInfoHelper(int id, APlayer player, HeroName name, boolean isAI, RoleType role) {
        player.setName(name);
        if (name == HeroName.ZhaoYun) {
            ISkill skill = new ZhaoYun_Courage();
            player.setSkill(skill);
            player.setMaxHP(4);
            player.setCurrentHP(4);
            player.setKingdom(Kingdoms.SHU);
        } else if (name == HeroName.GuanYu) {
            ISkill skill = new GuanYu_MasterOfWarfare();
            player.setSkill(skill);
            player.setMaxHP(4);
            player.setCurrentHP(4);
            player.setKingdom(Kingdoms.SHU);
        } else if (name == HeroName.CaoCao) {
            ISkill skill = new CaoCao_Treachery();
            player.setSkill(skill);
            player.setMaxHP(4);
            player.setCurrentHP(4);
            player.setKingdom(Kingdoms.WEI);
        } else if (name == HeroName.GuoJia) {
            ISkill skill = new GuoJia_Talented();
            player.setSkill(skill);
            player.setMaxHP(3);
            player.setCurrentHP(3);
            player.setKingdom(Kingdoms.WEI);
        } else if (name == HeroName.ZhangLiao) {
            player.setSkill(null); // TODO
            player.setMaxHP(4);
            player.setCurrentHP(4);
            player.setKingdom(Kingdoms.WEI);
        } else if (name == HeroName.MaChao) {
            ISkill skill = new MaChao_Horsemanship();
            player.setSkill(skill);
            player.setMaxHP(4);
            player.setCurrentHP(4);
            player.setKingdom(Kingdoms.SHU);
        } else if (name == HeroName.ZhenJi) {
            ISkill skill = new ZhenJi_Siren();
            player.setSkill(skill);
            player.setMaxHP(3);
            player.setCurrentHP(3);
            player.setKingdom(Kingdoms.WEI);
        }
        player.setAttackRange(1);
        player.setAttackAbility(1);
        player.setRoleType(role);
        player.setAI(isAI);
        player.setId(id);
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
    public static int getDistance(APlayer player1, APlayer player2) {
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
