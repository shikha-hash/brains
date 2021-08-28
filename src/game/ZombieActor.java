package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

/**
 * Base class for Actors in the Zombie World
 * @author ram
 *
 */
public abstract class ZombieActor extends Actor {
	
	public ZombieActor(String name, char displayChar, int hitPoints, ZombieCapability team) {
		super(name, displayChar, hitPoints);
		
		addCapability(team);
	}
	/**
	 * Method iterates through actor's inventory, and return any
	 * items that a gun type.
	 * @return gun item
	 */
	 public ArrayList<Gun> getGuns() {
		ArrayList<Gun> guns = new ArrayList<Gun>(); 
		for (Item item : inventory) {
			if (item.asGun() != null) {
				 guns.add(item.asGun());
				}
			}
		
		return guns;
	 }
	 public Ammo getAmmo() {
		 for (Item item : inventory) {
			 if (item.asAmmo()!= null) {
				 return item.asAmmo();
			 }
		 }
		 return null;
	 }
	 @Override
	 public int getHitpoints() {
		 return hitPoints;
	 }
	 
	 public Action getLoadGunAction() {
		 if (this.getAmmo() != null) {
				for (Gun gun : this.getGuns()) {
					return new LoadGunAction(gun, this.getAmmo());
				}
			}
		 return null;
	 }
	 
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions list = super.getAllowableActions(otherActor, direction, map);
		if (otherActor.hasCapability(ZombieCapability.UNDEAD) != this.hasCapability(ZombieCapability.UNDEAD))
			list.add(new AttackAction(this));
		return list;
	}
	
}
 