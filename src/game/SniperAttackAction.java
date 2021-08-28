package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SniperAttackAction extends AttackAction{
	private Sniper sniper;
	private String result = "";
	

	/**
	 * Sniper attack action is a special action called from Snipeaction, 
	 * when the player chooses to fire the sniper from the submenu
	 */
	SniperAttackAction(Actor target, Sniper sniper, String result)	{
		this.target = target;
		this.sniper = sniper;
		this.result = result;
				
	}
	@Override 
	public String execute(Actor actor, GameMap map){
		int damage;
		
		//Handles if sniper has been aimed for 0 turns
		if (sniper.getTurnsAiming() == 0 & rand.nextInt(3) <= 2) {
			damage = sniper.damage();
			return actor + " snipes for " + damage + " damage " + sniperDamage(actor, target, map,damage, result);	
		}
		
		// case where sniper is aimed for one turn
		if (sniper.getTurnsAiming() == 1 & rand.nextInt(9) <= 8) {
			damage = sniper.damage()*2;
			return actor + " snipes for" + damage + " damage " + sniperDamage(actor, target, map,damage, result);	
		}
		// case where actor has aimed for two or more turns
		if (sniper.getTurnsAiming() >= 2) {
			damage = target.getHitpoints();
			return sniperDamage(actor, target, map, damage, result);	
		}
		// sniper is reset after attacking
		sniper.setReady(false);
		sniper.fireGun();
		return " " + actor +  "  misses";
	
		
	}
	
	/**
	 * Method damages the target actor, and produces the correct output string, if target is killed
	 * @param actor
	 * @param target
	 * @param map
	 * @param damage
	 * @param result
	 * @return
	 */
	public String sniperDamage(Actor actor, Actor target, GameMap map, int damage, String result ) {
		// we only want a new line if  the existing result is not blank
		// result
		// damage target does the damage to the target
		String killedActor = damageTarget(actor, target, map, damage);
		if (!(killedActor == null)) {
			result =  System.lineSeparator() + killedActor;
			return result;
		}
		return "";
	}
	
	@Override
	public String menuDescription(Actor actor) {
		return actor + " snipes " + target;
		
	}
}