package game;

import edu.monash.fit2099.engine.GameMap;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.NumberRange;

public class ActorsFromMap {
	private GameMap map;
	private NumberRange width;
	private NumberRange height;
	
	/**
	 * 
	 * @param map
	 */

	
	ActorsFromMap(GameMap map){
		this.map = map;
		this.width = map.getXRange();
		this.height = map.getYRange();
	}
	
	public ArrayList<Actor> getActors(){
		ArrayList<Actor> actors = new ArrayList<Actor>();
		for (int x : width) {
			for (int y : height) {
				if (map.at(x,y).getActor() != null) {
					actors.add(map.at(x,y).getActor());
					
				}
			}
		}
	return actors;
	}
}
