package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class LoadGunAction extends Action{
	/**
	 * Action that allows an actor to load a gun
	 */
	private Ammo ammo;
	private Gun gun;
	
	LoadGunAction(Gun gun, Ammo ammo){
		this.ammo = ammo;
		this.gun = gun;
				
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		gun.loadGun(ammo.getClipSize());
		actor.removeItemFromInventory(ammo);
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		
		return actor + " loads " + gun.toString();
	}
	

}
