package edu.monash.fit2099.interfaces;

import game.Ammo;
import game.Gun;

/**
 * This interface provides the ability to add methods to Item, without modifying code in the engine,
 * or downcasting references in the game.   
 */
public interface ItemInterface {
	/**
	 * Override this method to get the number of hitpoins healed from this item
	 * @return
	 */
	default int getHealPoints() {
		return 0;
	} 
	/**
	 * casts an item into a gun if possible 
	 * @return a reference to the current Item as type Gun,  or null if this Item isn't a Gun
	 */
	default Gun asGun() {
		return this instanceof Gun ? (Gun) this : null;
	}
	/**
	 * casts an item as ammunition if possible
	 * @return a reference to the current Item as type Ammunition,  or null if this Item isn't a Gun
	 */
	default Ammo asAmmo() {
		return this instanceof Ammo ? (Ammo) this : null;
	}
}