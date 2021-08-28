package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * allows the actor to say something
 * @author shikha
 *
 */
public class SayAction extends Action{
	String stuffToSay;
	/**
	 * Constructor.
	 * @param stuffToSay string that actor says 
	 */
	public SayAction(String stuffToSay) {
		// TODO Auto-generated constructor stub
		this.stuffToSay=stuffToSay;
	}
	/**
	 * returns a descriptive string
	 * @param actor The actor performing the action
	 * @param map the map the actor is on
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		String result=actor+" \""+stuffToSay+"\" ";
		return result;
	}
	
	/**
	 * returns a descriptive string
	 * @deprecated not used here . for future use
	 */

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
