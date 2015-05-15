package com.logic.player;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;







import com.card.interfaces.*;
import com.gui.gaming.DeckEquipmentPanel;
import com.gui.gaming.DeckHandCardPanel;
import com.gui.gaming.DeckPanel;
import com.gui.gaming.OtherPlayerPanel;
import com.hero.skills.interfaces.ISkill;
import com.logic.interfaces.IPlayer;
import com.system.constants.CardConst;
import com.system.enums.GameStage;
import com.system.enums.HeroName;
import com.system.enums.Kingdoms;
import com.system.enums.RoleType;
import com.system.utils.IDatabase;

public abstract class APlayer implements IPlayer{

	 public IDatabase Database;
	 private int id;
	 protected int maxHP;
	 protected int currentHP;
	 protected List<ACard> hands;
	 protected  AmorCard amor;
	 protected PlusMountCard plusMount;
     protected MinusMountCard minusMount;
	 protected WeaponCard weapon;
	 protected int attackRange;
	 protected int attackAbility;
	 protected int position; //0 1 2 3 4
	 protected HeroName name;
	 protected RoleType roleType;
     protected Kingdoms kingdom;
	 
	 public GameStage gameStage;
	 protected ISkill skill;
	 protected int drawCardNum = 2;
	 protected int discardNum = 0;
	 protected ACard beingUsedCard;
	 private APlayer nextPlayer;
	 private boolean isAI;
	 private boolean isSkipped;
	 private boolean castingcard;
	 private boolean usingSkill;
	 private DeckEquipmentPanel deckEquipmentPanel;
	 private DeckHandCardPanel deckHandCardPanel;
	 private OtherPlayerPanel otherPlayerPanel;
     private DeckPanel deckPanel;
	 private APlayer targetPlayer;
	 private BufferedImage profile;
	 private BufferedImage healthBar;
     static int currentId = 0;
     protected List<ACard> discardList;

	 /**
	  * check if a card can be casted.
	  * @param cards always be the player's handcard.
	  * @return a list of cards can be casted.
	  */
	 public List<ACard> getAvailableCards(List<ACard> cards){ 
		 if(gameStage == GameStage.begin || gameStage == gameStage.check || gameStage == GameStage.drawCard){
			 return new ArrayList<ACard>();
		 }if(gameStage == GameStage.castCard){
			 List<ACard> listType = new ArrayList<ACard>();
			 for (ACard c : cards) {
					if (c != null && c.getType() == CardConst.CardType_Dodge) {
						listType.add(c);
					}
				}
			 cards.removeAll(listType);
		 }
		return cards;
	}
	 
	 public RoleType getRoleType() {
			return roleType;
		}

	public void setRoleType(RoleType roleType) {
			this.roleType = roleType;
		}

	 
	 public int getMaxHP() {
		 return maxHP;
	 }
	 
	 public void setMaxHP(int maxHP) {
		 this.maxHP = maxHP;
	 }
	 
	 public void setCurrentHP(int i) {
			// TODO Auto-generated method stub
		  if (i > maxHP) {
			i = maxHP;
		 }
		  this.currentHP = i;
          this.updateGuiHP();
		}

	 public int getCurrentHP() {
			// TODO Auto-generated method stub
			return this.currentHP;
		}
	 
	 public AmorCard getAmor()
	 {
		 return this.amor;
	 }
	 
	 public void setAmor(AmorCard amor)
	 {
		 this.amor = amor;
	 }
		 
	 public PlusMountCard getPlusMount() {
		 return plusMount;
	 }
	 
	 public void setPlusMount(PlusMountCard mount) {
		 this.plusMount = mount;
	 }

     public MinusMountCard getMinusMount() {
        return minusMount;
    }

     public void setMinusMount(MinusMountCard mount) {
        this.minusMount = mount;
    }
	 
	 public WeaponCard getWeapon() {
		 return weapon;
	 }
	 
	 public void setWeapon(WeaponCard weapon) {
		 this.weapon = weapon;
	 }
	 
	 public int getAttackRange() {
		if (weapon != null) {
			attackRange = weapon.getAttackRange();
		} if (minusMount != null) {
			attackRange++;
		 }
		 return attackRange;
	 }
	 
	 public void setAttackRange(int attackRange) {
		 this.attackRange = attackRange;
	 }
	 
	 public void setAttackAbility(int num){
		 if(num <= 0){
			 num = 1;
		 }
		 this.attackAbility = num;
	 }
	 
	 public int getAttackAbility(){
		 return this.attackAbility;
	 }
	 
	 public List<ACard> getHands() {
        // TODO Auto-generated method stub
        return this.hands;
	}

	 public void setHands(List<ACard> list) {
        // TODO Auto-generated method stub
        this.hands = list;
        updateGuiCardNum();
	}

    public ISkill getSkill() {
        return skill;
    }

    public void setSkill(ISkill skill) {
        this.skill = skill;
    }

    public void activateSkill(List<ACard> cards, List<APlayer> players) {
        this.skill.use(this, cards, players);
    }

    public boolean checkSkill(List<ACard> cards, List<APlayer> players) {
        return this.skill.check(this, cards, players);
    }

    public HeroName getName() {
        return name;
    }

    public void setName(HeroName name) {
        this.name = name;
    }

    public void setDrawCardNum(int num){
		 this.drawCardNum = num;
	 }
	 
	 public int getDrawCardNum(){
		 return this.drawCardNum;
	 }
	 
	 public void setDiscardNum(int num){
		 this.discardNum = num;
	 }
	 
	 public int getDiscardNum(){
		 return this.discardNum;
	 }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    public void setBeingUsedCard(ACard card){
    	this.beingUsedCard = card;
    }
    
    public ACard getBeingUsedCard(){
    	return beingUsedCard;
    }

	public APlayer getNextPlayer() {
		return nextPlayer;
	}

	public void setNextPlayer(APlayer nextPlayer) {
		this.nextPlayer = nextPlayer;
	}

	public boolean isSkipped() {
		return isSkipped;
	}

	public void setSkipped(boolean isSkipped) {
		this.isSkipped = isSkipped;
	}

	public boolean isCastingcard() {
		return castingcard;
	}

	public void setCastingcard(boolean castingcard) {
		this.castingcard = castingcard;
	}

	public boolean isUsingSkill() {
		return usingSkill;
	}

	public void setUsingSkill(boolean usingSkill) {
		this.usingSkill = usingSkill;
	}

	public boolean isAI() {
		return isAI;
	}

	public void setAI(boolean isAI) {
		this.isAI = isAI;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public int issueId() {
        this.setId(APlayer.currentId);
        APlayer.currentId++;
        return this.getId();
    }

	public DeckHandCardPanel getDeckHandCardPanel() {
		return deckHandCardPanel;
	}

	public void setDeckHandCardPanel(DeckHandCardPanel deckHandCardPanel) {
		this.deckHandCardPanel = deckHandCardPanel;
	}

	public APlayer getTargetPlayer() {
		return targetPlayer;
	}

	public void setTargetPlayer(APlayer targetPlayer) {
		this.targetPlayer = targetPlayer;
	}

    public Kingdoms getKingdom() {
        return kingdom;
    }

    public void setKingdom(Kingdoms kingdom) {
        this.kingdom = kingdom;
    }

	public BufferedImage getProfile() {
		return profile;
	}

	public void setProfile(BufferedImage profile) {
		this.profile = profile;
	}

	public OtherPlayerPanel getOtherPlayerPanel() {
		return otherPlayerPanel;
	}

	public void setOtherPlayerPanel(OtherPlayerPanel otherPlayerPanel) {
		this.otherPlayerPanel = otherPlayerPanel;
	}

	public BufferedImage getHealthBar() {
		return healthBar;
	}

	public void setHealthBar(BufferedImage healthBar) {
		this.healthBar = healthBar;
	}

	public List<ACard> getDiscardList() {
		return discardList;
	}

	public void setDiscardList(List<ACard> discardList) {
		this.discardList = discardList;
	}

    public void setDeckPanel(DeckPanel deckPanel) {
        this.deckPanel = deckPanel;
    }

    public DeckPanel getDeckPanel() {
        return deckPanel;
    }

    public boolean isCanDiscard() {
		int tmp = hands.size() - currentHP;
		if (discardList.size() <= tmp) {
			return true;
		}
		return false;
	}

	public DeckEquipmentPanel getDeckEquipmentPanel() {
		return deckEquipmentPanel;
	}

	public void setDeckEquipmentPanel(DeckEquipmentPanel deckEquipmentPanel) {
		this.deckEquipmentPanel = deckEquipmentPanel;
	}
	
    public void updateGuiHP() {
        if (otherPlayerPanel == null && deckPanel == null) {return;}
        if (isAI) {
            otherPlayerPanel.updateHP();
        } else {
            deckPanel.getDeckProfilePanel().updateHP();
        }
    }

    public void updateGuiCardNum() {
        if (otherPlayerPanel == null) {return;}
        if (isAI) {
            otherPlayerPanel.updateCardNum();
        }
    }
}


