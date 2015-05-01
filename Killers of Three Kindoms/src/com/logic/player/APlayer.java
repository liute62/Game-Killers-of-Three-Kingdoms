package com.logic.player;

import java.util.ArrayList;
import java.util.List;



import com.card.interfaces.*;
import com.hero.skills.interfaces.ISkill;
import com.logic.interfaces.IPlayer;
import com.system.constants.CardConst;
import com.system.enums.GameState;
import com.system.enums.HeroName;
import com.system.enums.RoleType;
import com.system.utils.IDatabase;

public abstract class APlayer implements IPlayer{

	public IDatabase Database;
	
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
	 //protected String heroName;
	 //protected String roleName;
	 //protected int roleType;
	 protected HeroName name;
	 protected RoleType roleType;
	 
	public GameState gameState;
	 protected ISkill skill;
	 protected int drawCardNum = 2;
	 protected int discardNum = 0;
	 protected ACard beingUsedCard;

	 
	 public List<ACard> getAvailableCards(List<ACard> cards){ 
		 if(gameState == GameState.begin || gameState == gameState.check || gameState == GameState.drawCard){
			 return new ArrayList<ACard>();
		 }if(gameState == GameState.castCard){
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
}


