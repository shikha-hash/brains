package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * This action allows the player to harvest ripe crops.
 * This action will reset the ground  to dirt and place food in the
 * player's inventory
 * 
 * @author catopoynton
 *
 */

public class HarvestAction extends Action{
	
	private Location harvestLocation;
	
	/**
	 * Constructor
	 * @param location
	 */
	HarvestAction(Location location){
		this.harvestLocation = location;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		harvestLocation.setGround(new Dirt());
		actor.addItemToInventory(new Food());
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " harvests crops";
		
	}

	

	}

