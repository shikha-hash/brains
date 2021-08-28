package game;


import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;
import game.maps.MapClass;


/**
 * The main class for the zombie apocalypse game.
 *
 */
public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		
		GameMap gameMap = MapClass.zombieWorldMap;
		GameMap townGameMap = MapClass.townMap;
		world.addGameMap(gameMap);
		world.addGameMap(townGameMap);
		
		gameMap.at(3, 3).addItem(new Sniper(20));
		gameMap.at(3, 3).addItem(new Shotgun());
		gameMap.at(3, 4).addItem(new Ammo(10));
		

		//Placing stuff on the default map.
		{
			//Place the vehicle on the default map
			gameMap.at(2, 3).addItem(new Vehicle("Car to Town"));
			
			
			//Place the player on the default map.
			Actor player = new Player("Player", '@', 100);
			world.addPlayer(player, gameMap.at(2, 2));
			
		    // Place some random humans
			String[] humans = {"Carlton", "May", "Vicente", "Andrea", "Wendy",
					"Elina", "Winter", "Clem", "Jacob", "Jaquelyn"};
		    // Place some random Zombies
			String[] zombies = {"Groan", "Boo", "Uuuurgh", "Mortalis", "Gaaaah",
					"Aaargh"};
		    // Place some random Farmers
			String[] farmers = {"Farmer Bob", "Farmer Dixy", "Farmer Joe", "Farmer RJ"};
			
			int x, y;
			for (String name : humans) {
				Human human=new Human(name);
				do {
					x = (int) Math.floor(Math.random() * 20.0 + 30.0);
					y = (int) Math.floor(Math.random() * 7.0 + 5.0);
				} 
				while (gameMap.at(x, y).containsAnActor()||!(gameMap.at(x, y).canActorEnter(human)));
				gameMap.at(x,  y).addActor(human);	
			}
			
			// place a simple weapon
			gameMap.at(74, 20).addItem(new Plank());
			gameMap.at(21, 12).addItem(new Plank());
			
			//Added more Zombies
			
			for (String name : zombies) {
				Zombie zombie=new Zombie(name);
				do {
					x = (int) Math.floor(Math.random() * 54.0 +7.0);
					y = (int) Math.floor(Math.random() * 14.0 + 3.0);
				} 
				while (gameMap.at(x, y).containsAnActor()||!(gameMap.at(x, y).canActorEnter(zombie)));
				gameMap.at(x,  y).addActor(zombie);	
			}
			
			//Added some farmers 
			
			for (String name : farmers) {
				Farmer farmer=new Farmer(name);
	
				do {
					x = (int) Math.floor(Math.random() * 60.0 + 10.0);
					y = (int) Math.floor(Math.random() * 7.0 + 4.0);
				} 
				while (gameMap.at(x, y).containsAnActor()||!(gameMap.at(x, y).canActorEnter(farmer)));
				gameMap.at(x,  y).addActor(farmer);	
			}
			// Placing Mambo Marie
			gameMap.at(79, 5).addActor(new MamboMarie());
			
			
			
		}
		
		//Placing stuff on the town Map
		{
			townGameMap.at(25,12).addItem(new Vehicle("Car to Zombie World"));
		}
		world.run();
	}
}
