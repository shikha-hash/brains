
package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.WeaponItem;

public class Gun extends WeaponItem{
	protected Actions actions = new Actions();
	protected int ammo = 0;

	public Gun(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, damage, verb);
		// TODO Auto-generated constructor stub
	}
	
	public void loadGun(int magazine) {
		this.ammo += magazine;
	}
		
	public void fireGun() {
		ammo = ammo -1;
		System.out.println(ammo);
	}
	
}
