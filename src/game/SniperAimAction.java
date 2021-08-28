package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SniperAimAction extends Action{
	Sniper sniper;
	String result;
	/**
	 * This action represents the actor to choosing to aim the sniper
	 * 
	 */
	
	/**
	 * constructer
	 * @param sniper: the sniper gun being used
	 * @param result: the output string
	 */
	SniperAimAction (Sniper sniper, String result){
		this.sniper = sniper;
		this.result = result;
	}
	/**
	 * The execute method increments the aiming count of the Sniper by 1, allowing th sniper
	 * to become more deadly.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		sniper.incrementTurnsAiming();
		if (!(result == "")) {
			return result + System.lineSeparator() + menuDescription(actor);
		}
		
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
	
		return actor + " aims sniper";
	}
	
	

}
