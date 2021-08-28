package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Vehicle extends Item{

	private Location location;
	public Location getLocation() {
		return location;
	}
	public Vehicle(String name) {
		super(name, 'V', false);
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Action> getAllowableActions() {
		// TODO Auto-generated method stub
		Actions actions=new Actions();
		
		actions.add(new ChangeMapAction(this));
		return actions.getUnmodifiableActionList();
	}
	@Override
	public void tick(Location currentLocation) {
		// TODO Auto-generated method stub
		this.location=currentLocation;
		super.tick(currentLocation);

	}
}
