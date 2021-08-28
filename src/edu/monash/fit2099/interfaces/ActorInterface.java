package edu.monash.fit2099.interfaces;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

/**
 * This interface provides the ability to add methods to Actor, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface ActorInterface {
	/**
	 * override this method to return the number of hitpoints the actor has
	 */
	default int getHitpoints() {
		return 0;
	}

}
