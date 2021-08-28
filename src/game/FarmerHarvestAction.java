package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class FarmerHarvestAction extends Action{

private Location harvestLocation;
	
	/**
	 * Constructor
	 * @param location
	 */
	FarmerHarvestAction(Location location){
		this.harvestLocation = location;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		harvestLocation.setGround(new Dirt());
		harvestLocation.addItem(new Food());
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " harvests crops";
	}
}