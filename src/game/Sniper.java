package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;

public class Sniper extends Gun{
	private int turnsAiming = 0;
	private boolean ready = false;
	private Actor target;
	/**
	 * Class that represents the sniper gun. Sniper can be aimed for a number of turns to increase damage
	 * if actor is interrupted during aiming, the sniper will choose a new target.
	 */
	
	 /**
	  * Constructor
	  * @param basic damage dealt by sniper if not aimed.
	  */
	public Sniper(int damage) {
		super("Sniper", 'x', damage, "snipes");
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * If fireSniperAction has been selected, this will become true.
	 * if actor interrupted, while aiming this will set to false
	 * @param ready
	 */
	public void setReady(boolean ready) { 
		this.ready = ready;
	}
	
	/**
	 * allows classes to view the sniper's ready status
	 * @param ready
	 * @return
	 */
	public boolean isReady() {
		return ready;
	}
	
	/**
	 *Increments the turns the player has being aiming the sniper for  
	 */
	public void incrementTurnsAiming() {
		this.turnsAiming  += 1;
	}
	
	public int getTurnsAiming() {
		return turnsAiming;
	}
	
	/**
	 * set the sniper's target
	 * @param actor
	 */
	public void setTarget(Actor target) {
		this.target = target;
	}
	
	/**
	 * fetches the sniper's current target
	 */
	public Actor getTarget() {
		return target;
	}
	/**
	 * If sniper is loaded return sniperAction
	 */
	
	
	@Override
	public List<Action> getAllowableActions() {
		// TODO Auto-generated method stub
		actions = new Actions();
		if (ammo > 0) {
			actions.add(new SnipeAction(this));
		}
		return actions.getUnmodifiableActionList();
	}
	
}