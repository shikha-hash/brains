package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public class MamboMarie extends ZombieActor{
	static boolean mariePresent=false;
	static int turnCount=0;
	public static boolean isMariePresent() {
		return mariePresent;
	}

	public MamboMarie() {
		super("Mambo Marie",'M',100, ZombieCapability.VODOO);
		mariePresent=true;
	}
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// TODO Auto-generated method stub
		turnCount++;
		if (turnCount%30==0) {
			mariePresent=false;
			return new VanishAction();
		}
		else if (turnCount%10==0) {
			return new SummonZombiesAction();		
		}
		
		return new WanderBehaviour().getAction(this, map);
	}
}
