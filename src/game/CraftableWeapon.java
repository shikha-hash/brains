package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * A class for the weapons which may be crafted into better weapons 
 * @author shikha
 *
 */

public class CraftableWeapon extends WeaponItem{
	private Actions actions=new Actions();
	
	/**
	 * Constructor.
	 * 
	 * Creates a new CraftableWeapon object with an ItemCapabiity (Craftable or non_craftable) 
	 * @param name name of the weapon 
	 * @param displayChar character used to display weapon on the map when not being carried 
	 * @param damage damage done by a particular weapon
	 * @param verb a string which shows action performed by the weapon
	 * @param itemCapability used to determine whether the weapon is craftable or not
	 */
	public CraftableWeapon(String name, char displayChar, int damage, String verb,ItemCapability itemCapability) {
		super(name, displayChar, damage, verb);
		// TODO Auto-generated constructor stub
		this.addCapability(itemCapability);
		
	}
	
	/**
	 * getAllowableActions returns a List of actions that weapon lets actor perform.
	 */
	@Override
	public List<Action> getAllowableActions() {
		// TODO Auto-generated method stub
		return actions.getUnmodifiableActionList();
	}
	
	/**
	 * 
	 * getCraftItemAction Checks whether the weapon is craftable or not
	 * and returns a craftItemAction if craftable, else, returns null
	 * @param actor the Actor carrying the weapon
	 * @return a craftItemAction or null.
	 */
	public CraftItemAction getCraftItemAction(Actor actor) {
		// TODO Auto-generated method stub
		if(this.hasCapability(ItemCapability.CRAFTABLE)&&actor.getInventory().contains(this)) {
			
			return new CraftItemAction(this);
		}
		return null;
	}
	
	/**
	 * tick keeps a track of the turns.
	 * only called when the item is being carried.
	 * also adds craftItemAction to the actions list. 
	 * 
	 */
	@Override
	public void tick(Location currentLocation, Actor actor) {
		super.tick(currentLocation, actor);
		actions.add(getCraftItemAction(actor));
	}
}
