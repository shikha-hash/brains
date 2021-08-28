package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;


/**
 * 
 * A crop that can be harvested when ripe
 * @author catopoynton
 *
 */
public class Crop extends Ground {
	private int age = 0;
	
			
	public Crop() {
		super('c');	
		
	}
	/**
	 * when crop is ripe, its character is changed to alert the player that it is ready for harvest
	 */
	@Override
	public void tick(Location location) {
		super.tick(location);
		
		age ++;
		if (age >= 20) {
			displayChar = 'C';
			addCapability(GroundCapabilities.RIPE);
		}
	}

	/**
	 * Farmer's can fertilize crops, speeding up their time until ripe
	 */
	public void fertilize() {
		this.age += 10;
	}
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		if (this.hasCapability(GroundCapabilities.RIPE)) {
			Actions actions = new Actions();
			actions.add(new HarvestAction(location));
			return actions;
		}
		return new Actions();
	}
	}
	

