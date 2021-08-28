package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;
	/**
	 * Random number generator
	 */
	protected Random rand = new Random();
	
	public AttackAction() {
		
	}

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 */
	public AttackAction(Actor target) {
		this.target = target;
	}

	@Override
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();
//Bite hit probability is 20%
		if (weapon.verb().equals("bites")){
			if (!(rand.nextInt(101)<=20)) {
				return actor + " bite misses " + target + ".";
			}
			actor.heal(5);
		}
		
		else{
			if (rand.nextBoolean()) {
				return actor + " misses " + target + ".";
			}
		}

		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";

		String damageResult = damageTarget(actor,target, map, damage);
		
		if (damageResult != null) {
			result += System.lineSeparator() + damageResult;
		}

		return result;
	}
	
	public String damageTarget(Actor actor, Actor target, GameMap map, int damage) {
		String result = null;
		target.hurt(damage);
		System.out.println("here");
		if (!target.isConscious()) 
		{
			if(target.hasCapability(ZombieCapability.ALIVE)) {
				map.locationOf(target).addItem(new Corpse(target.toString()));
			}
			if(target.hasCapability(ZombieCapability.UNDEAD)) {
				PortableItem corpse = new PortableItem("Dead", '%');
				map.locationOf(target).addItem(corpse);
			}
			Actions dropActions = new Actions();
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction());
			for (Action drop : dropActions)		
				drop.execute(target, map);
			map.removeActor(target);	
			
			result = target + " is killed.";
		}

		return result;
	}
		
	

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}
}
