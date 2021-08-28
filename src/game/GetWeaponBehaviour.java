package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.WeaponItem;
import edu.monash.fit2099.engine.PickUpItemAction;

import java.util.ArrayList;
import java.util.List;

public class GetWeaponBehaviour implements Behaviour{
	/**
	 * A class that generates a PickUpItemAction if the current Actor is 
	 * standing on a WeaponItem, if no weapon is available returns the null action.
	 * @param actor the Actor enacting the behavior
	 * @param map the map that actor is currently on
	 */
	
		@Override
		public Action getAction(Actor actor, GameMap map) {
			List<Item> items = new ArrayList<Item>(map.locationOf(actor).getItems());
			
			for (Item item: items) {
				if (WeaponItem.class.isInstance(item))
					if(((Zombie)actor).getArmsPresent()>0) {
						return new PickUpItemAction(item);
					}
		
			}
			return null;
	
		}
}