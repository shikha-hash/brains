package game;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

import java.util.Random;

/**
 * Action that allows farmers to plant crops in the dirt
 */

public class PlantAction extends Action {
	private Random random = new Random();


	/**
	 * if the type of ground of adjacent to the farmer is dirt, farmer has a 33% chance of growing crops there
	 * 
	 * 
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		int count = 0;
		for (Exit exit : map.locationOf(actor).getExits()) {
            Location adjacentLocation = exit.getDestination();
            if ((adjacentLocation.getGround() instanceof Dirt) && (random.nextInt(100) <= 33)){
            	adjacentLocation.setGround(new Crop());
            	count ++;
            	
            }
		} 
		if (count > 0) {
       	 	return actor + " planted " + count + " crops!";
        }
		return menuDescription(actor);
	}
	

	@Override
	public String menuDescription(Actor actor) {	
		return actor + " tried unsucessfully to plant crops.";
	}
	

}	
