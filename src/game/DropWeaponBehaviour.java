package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

/**
 * Allows an actor to drop the weapon if they're holding any 
 * @author shikha
 *
 */

public class DropWeaponBehaviour implements Behaviour{
	Random rand=new Random();
	
	/**
	 * It checks the number of arms the actor(Zombie) has, and returns dropItemAction 		accordingly. 
	 * @param actor the Actor enacting the behaviour
	 * @param map the map that actor is currently on
	 * @return an Action, or null if no DropItemAction is possible
	 */

	@Override
	public Action getAction(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		Weapon weapon=actor.getWeapon();
		if(!(weapon.verb().equals("punches")||weapon.verb().equals("bites"))) {
			if(((Zombie)actor).getArmsPresent()==1&&rand.nextBoolean()) {
				return new DropItemAction((Item) weapon); 
			}
			else if(((Zombie)actor).getArmsPresent()==0) {
				return new DropItemAction((Item) weapon); 
			}
		}
		return null;
		
	}

}
