package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

/**
 * Class representing the Player.
 */
public class Player extends Human {

	private Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}
	/**
	 * If player is damaged sniper aiming is reset
	 */
	@Override
	public void hurt(int points) {
		hitPoints -= points;
		disableSniper();
	}
	/**
	 * this method is called when the player looses theirfocus, and clears the sniper's current target.
	 */
	public void disableSniper() {
		for (Gun gun : this.getGuns()) {
			if (gun instanceof Sniper) {
				Sniper sniper = (Sniper) gun;
				sniper.setReady(false);
			}
		}
	}
	/**
	 * Method presents player with available actions
	 * if action is not SniperAction, then the sniper is reset
	 * 
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		
		if (!(getLoadGunAction() == null)){
			actions.add(getLoadGunAction());
		}
		

		Action action = menu.showMenu(this, actions, display);
		if (!(action instanceof SnipeAction)) {
			disableSniper();
		}
		return action;
		
	}
	
}
