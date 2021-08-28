package game;


import java.util.ArrayList;
import java.util.Collections;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * A class which generates a harvestAction, if the farmer is standing on or next to a 
 * ripe crop
 */
public class HarvestBehabiour implements Behaviour{
	
		
	@Override
	//Creates a list of areas that can be harvested and passes a random location
	//to HarvestAction
	public Action getAction(Actor actor, GameMap map) {
		
		ArrayList<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		ArrayList<Location> cropLocations =new ArrayList<Location>();
		for (Exit exit: exits) {
			if (exit.getDestination().getGround().hasCapability(GroundCapabilities.RIPE)) {
				cropLocations.add(exit.getDestination());
			}
		}
		if (map.locationOf(actor).getGround().hasCapability(GroundCapabilities.RIPE)) {
			cropLocations.add(map.locationOf(actor));
		}

		if (!cropLocations.isEmpty()){
			Collections.shuffle(cropLocations);
			return new FarmerHarvestAction(cropLocations.get(0));
				
	}
		return null;
	}	

}
 