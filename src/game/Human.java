package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Class representing an ordinary human.
 * 
 * 
 * @author ram
 *
 */
public class Human extends ZombieActor {
	//List of behaviours for Humans
	private ArrayList<Behaviour> behaviours = new ArrayList<Behaviour>();

	/**
	 * The default constructor creates default Humans
	 * 
	 * @param name the human's display name
	 */
	public Human(String name) {
		super(name, 'H', 50, ZombieCapability.ALIVE);
		
		behaviours.add(new EatBehaviour());
		behaviours.add(new WanderBehaviour());
		
	}
	
	/**
	 * The protected constructor can be used to create subtypes
	 * of Human, such as the Player
	 * 
	 * @param name the human's display name
	 * @param displayChar character that will represent the Human in the map 
	 * @param hitPoints amount of damage that the Human can take before it dies
	 */
	protected Human(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints, ZombieCapability.ALIVE);
	}

	

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// FIXME humans are pretty dumb, maybe they should at least run away from zombies?
//		eat();
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			
			if (action != null)
				return action;
		}
		return new WanderBehaviour().getAction(this, map);
		
	}
	public int getHitPoints(){
		return this.hitPoints;	
	}
	public int getMaxHitPoints() {
		return this.maxHitPoints;	
	}

}
