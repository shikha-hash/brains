package game;



import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
/**
 * 
 * @author shikha
 *
 */
public class EatBehaviour implements Behaviour {
	/**
	 *This action allows the actor to eat food and heal health if the food is on the ground and if the actor is human
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		// TODO Auto-generated method stub

		if(actor.getDisplayChar()=='H') {

			if(actor.isConscious()&&((Human)actor).getHitPoints()<((Human)actor).getMaxHitPoints()) {
				for(Item item:map.locationOf(actor).getItems()) {
					if(item.toString().equals("Food")) {
						return new EatAction(item);
					}
				}
			}
		}
		return null;
	}

}
