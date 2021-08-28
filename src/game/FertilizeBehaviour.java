package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
 /**
  * If farmer is standing on an unripe crop, this behaviour will create a fertilise action
  * @author catopoynton
  *
  */
public class FertilizeBehaviour implements Behaviour{

	@Override
	public Action getAction(Actor actor, GameMap map) {
		if (map.locationOf(actor).getGround().getDisplayChar() == 'c')
			return new FertilizeAction();
		return null;
	}

}
