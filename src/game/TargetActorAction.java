package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class TargetActorAction extends Action{
	private Actor target;
	/**
	 * This is a dummy actions that allows the player to choose who they wish to target 
	 * with the sniper.
	 * @param target, the actor whom the player wishes to target.
	 */
	TargetActorAction(Actor target){
		this.target = target;
	}
	/**
	 * @return the Actor who the player wishes to target
	 */
	@Override
	public Actor getTarget() {
		return target;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		
		return "target " + target;
	}

}
