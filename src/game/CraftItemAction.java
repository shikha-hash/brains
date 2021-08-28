package game;

import java.util.HashMap;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Special action for crafting new weapons from pre-existing weapons. 
 * @author shikha
 *
 */
public class CraftItemAction extends Action{
	
	protected Item item;
	private Item craftedItem;
	/**
	 * hash map created which maps the names of the craftable weapons (such as left leg) to a new CraftableWeapon
	 * 
	 */
	private static HashMap<String, CraftableWeapon> weaponToCraftedWeapon=new HashMap<>();
	static {
		weaponToCraftedWeapon.put("Left Arm", new CraftableWeapon("Zombie Club", '/', 30, "smashes",ItemCapability.NON_CRAFTABLE));
		weaponToCraftedWeapon.put("Right Arm", new CraftableWeapon("Zombie Club", '/', 30, "smashes",ItemCapability.NON_CRAFTABLE));
		weaponToCraftedWeapon.put("Left Leg", new CraftableWeapon("Zombie Mace", '=', 50, "smashes",ItemCapability.NON_CRAFTABLE));
		weaponToCraftedWeapon.put("Right Leg", new CraftableWeapon("Zombie Mace", '=', 50, "smashes",ItemCapability.NON_CRAFTABLE));

	}
	
	/**
	 * Constructor.
	 *  
	 * @param item the item in question
	 */
	public CraftItemAction(Item item) {
		// TODO Auto-generated constructor stub
		this.item=item;
	}
	
	/**
	 * removes original weapon  and adds the crafted weapon to the player's inventory
	 * @param actor Actor holding the normal weapon 
	 * @param map the map that actor is currently on
	 * @return menuDescription for the actor
	 */
	
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		actor.removeItemFromInventory(item);;
		actor.addItemToInventory(craftedItem);;
		return menuDescription(actor);
	}

	
	/**
	 * returns a descriptive string
	 * @param actor The actor that is carrying the weapon
	 * @return string stating the action in a way suitable for the menu
	 */
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		craftedItem=weaponToCraftedWeapon.get(item.toString());
//		if(craftedItem!=null) {
			return actor+" crafts "+ item+" into "+craftedItem;
//		}
//		return null;
	}

}
