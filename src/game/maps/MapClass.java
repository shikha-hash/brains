package game.maps;

public class MapClass {
	public static TownMap townMap;
	public static ZombieWorldMap zombieWorldMap;
	static {
		townMap=new TownMap();
		zombieWorldMap=new ZombieWorldMap();
	}
}
