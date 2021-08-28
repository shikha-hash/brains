package game;

import java.util.Random;

import edu.monash.fit2099.engine.Location;

/**
 * A class that generates a Corpse object. the corpse rises after 10 turns and tick method is 
 * used to keep track of turns.
 * 
 * @authors shikha and Cato
 *
 */

public class Corpse extends PortableItem{

	private int turnsToZombify;
	
	/**
	 * Constructor.
	 * initialises corpse as an object.
	 * @param name name of the corpse
	 * 
	 */
	public Corpse(String name) {
		super(name,'%');
		// TODO Auto-generated constructor stub
		Random rand=new Random();
		turnsToZombify=rand.nextInt(5)+6;
		
	}
	
	/**
	 * tick tells that a turn has passed.
	 * turnsToZombify keeps decrementing by one and when variable gets to zero,
	 * and when no actor is already present at the location,
	 * corpse object is removed from the location and a zombie is added in its stead
	 */
	
	@Override
	public void tick(Location currentLocation) {
		// TODO Auto-generated method stub
		super.tick(currentLocation);
		turnsToZombify--;
		if(turnsToZombify<=0&&!currentLocation.containsAnActor()) {
			currentLocation.removeItem(this);
			currentLocation.addActor(new Zombie("undead"+name));
			
		}
	}
}
