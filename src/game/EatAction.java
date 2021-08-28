package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class EatAction extends Action {
	/**
	 * Special action for eating food
	 * 
	 * @author shikha
	 *
	 */
	private Item item;
	/**
	 * Constructor
	 * @param item the food item
	 */
	public EatAction(Item item) {
		// TODO Auto-generated constructor stub
		this.item=item;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
				actor.heal(item.getHealPoints());
				actor.removeItemFromInventory(item);
		
		
		return menuDescription(actor);
	}
	/**
	 * Shows a description suitable for the menu
	 */
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor+" eats "+item+" to heal "+item.getHealPoints()+" health";
	}

}
