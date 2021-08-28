package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class FireShotgunAction extends AttackAction{
	private String direction;
	private int weaponDamage;
	private Shotgun shotgun;
	

	/**
	 * Constructor, takes the direction in which the shotgun will be fired
	 * @param direction
	 */
	FireShotgunAction(String direction, int weaponDamage, Shotgun shotgun){
		
		this.direction =  direction;
		this.weaponDamage = weaponDamage;
		this.shotgun = shotgun;

	}
	/**
	 * For a given direction, gets a list of exits that are in the shotgun firing range. 
	 * All actors within the shot gun have an (independent) 75% chance of being damaged.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		String result = menuDescription(actor);
		//get the locations of the locations which the shotgun will hit.
		ArrayList<Location> attackLocations =  new ArrayList<Location>();
		for (Exit exit : map.locationOf(actor).getExits()) {
            if (exit.getName().contains(direction)) {
            	attackLocations.add(exit.getDestination());
            }
		}
		for (Location location : attackLocations) {
			String damageResult = null;
			Random rand = new Random();
			if (location.containsAnActor() & rand.nextInt(3) <= 2){
				damageResult = damageTarget(actor,location.getActor(),map,weaponDamage);	
			}
			
			if (damageResult != null) {
				result += System.lineSeparator() + damageResult;
			}		
		}
		shotgun.fireGun();
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + "fires shotgun " + direction;
	}

}
