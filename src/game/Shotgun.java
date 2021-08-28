package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.WeaponItem;

public class Shotgun extends Gun{
	
	/**
	 * Class which represents shotgun, shotgun can be picked up by the player. 
	 * requires player has ammo in their inventory before use.
	 * @param name
	 * @param displayChar
	 * @author catopoynton
	 */

	public Shotgun() {
		super("ShotGun", 'S', 50, "blasts");
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * If the shotgun has been loaded, allows player to choose
	 */
	@Override
	public List<Action> getAllowableActions() {
		// TODO Auto-generated method stub
		actions = new Actions();
		if (this.ammo > 0) {
			System.out.println(ammo);
			actions.add(new FireShotgunAction("North",this.damage(),this));
			actions.add(new FireShotgunAction("South",this.damage(),this));
			actions.add(new FireShotgunAction("East",this.damage(),this));
			actions.add(new FireShotgunAction("West",this.damage(),this));
			
		}
		return actions.getUnmodifiableActionList();		
	}
	

}
