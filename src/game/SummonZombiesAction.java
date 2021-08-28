package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SummonZombiesAction extends Action{

	private int x;
	private int y;

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		for (int i=0;i<5;i++) {
			Zombie zombie=new Zombie("Summoned Zombie");
			do {
				x = (int) Math.floor(Math.random() * 54.0 +7.0);
				y = (int) Math.floor(Math.random() * 14.0 + 3.0);
			} 
			while (map.at(x, y).containsAnActor()||!(map.at(x, y).canActorEnter(zombie)));
			map.at(x,  y).addActor(zombie);	
		}
		return actor+" summons five zombies!";
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
