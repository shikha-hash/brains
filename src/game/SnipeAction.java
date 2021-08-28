package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

public class SnipeAction extends Action{
	private Sniper sniper;
	
	/**
	 * constructor 
	 * @param takes the gun being fired
	 */
	SnipeAction(Sniper sniper){
		this.sniper = sniper;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		String result = "";
		Actor target;
		// if sniper does not have a target selected, this segment shows the player
		// the menu which allows them to choose a target
		// the target will be passed to the sniper
		if (! sniper.isReady()) {
			
			Actions actions = new Actions();
			Display display = new Display();
			Menu menu = new Menu();
			ActorsFromMap actorsInMap = new ActorsFromMap(map);
			
			for (Actor mapActor : actorsInMap.getActors()) {
				actions.add(new TargetActorAction(mapActor));
			}
			// if (! sniper.isReady()) {		
				
			Action targetAction = menu.showMenu(actor,actions , display);
			target = targetAction.getTarget();
			sniper.setTarget(target);
			sniper.setReady(true);
			result = actor + " targets  " + target;
		}
		
		// If a target has been selected, the user is show another menu which allows them to decide whether to 
		// aim or fire the sniper.
		
		Actions actions2 = new Actions();
		Display display2 = new Display();
		Menu menu2 = new Menu();
		
		actions2.add(new SniperAimAction(sniper, result));
		actions2.add(new SniperAttackAction(sniper.getTarget(), sniper, result));
		Action action = menu2.showMenu(actor, actions2, display2);
		result += action.execute(actor, map);
		return result;

	}
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " uses sniper";
	}

}
