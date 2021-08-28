package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;

public class PlantBehaviour implements Behaviour{
	/**
	 * A class that generates a PlantAction if the current actor is a farmer that is standing
	 * adjacent to a patch of dirt.
	 */
	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());

		
		for (Exit e: exits) {
			if (e.getDestination().getGround() instanceof Dirt)
				return new PlantAction();			
		}
		
		return null;
	}
	

}
