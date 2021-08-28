package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;

import game.PortableItem;
/**
 * Class which represents food, can be consumed by humans
 * @author catopoynton
 *
 */

public class Food extends PortableItem{
	
	Actions actions=new Actions();
	static int healPoints = 10;
	
	public Food() {
		super("Food", 'f');
		
	}
	
	public int getHealPoints() {
		return healPoints;
	}
	
	@Override
	public List<Action> getAllowableActions() {
		// TODO Auto-generated method stub
		actions=new Actions();
		actions.add(getEatAction());
		return actions.getUnmodifiableActionList();
	}

	Action getEatAction(){
		return new EatAction(this);
	}
}
