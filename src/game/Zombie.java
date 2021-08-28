package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * A Zombie.
 * 
 * Class representing a zombie.
 * 
 * @author ram and shikha
 * 
 *
 */
public class Zombie extends ZombieActor {
	/**
	 * declaration of limbs
	 */
	private static String leftArm="Left Arm";
	private static String rightArm="Right Arm";
	private static String leftLeg="Left Leg";
	private static String rightLeg="Right Leg";
	
	/**
	 * zombieLocation : current location of this Zombie
	 */
	
	private Location zombieLocation;
	private int legsPresent=2;
	private int armsPresent=2;
	private Behaviour zombieHuntBehaviour=new HuntBehaviour(Human.class, 10);
	private Behaviour zombieWanderBehaviour=new WanderBehaviour();
	private ArrayList<Behaviour> behaviours = new ArrayList<Behaviour>();
	
	/**
	 * Random number generator
	 */
	
	protected static Random rand = new Random();
	ArrayList<String> limbList=new ArrayList<String>();
	
	private boolean hurtThisTurn=false; 
	
	/**
	 * The default constructor creates default zombies and adds behaviours.
	 * 
	 * @param name name of the zombie.
	 */
	
	public Zombie(String name) {
		super(name, 'Z', 100, ZombieCapability.UNDEAD);
		initializeLimbs();
		behaviours.add(new DropWeaponBehaviour());
		behaviours.add(new AttackBehaviour(ZombieCapability.ALIVE));
		behaviours.add(new GetWeaponBehaviour());
		behaviours.add(zombieHuntBehaviour);
		behaviours.add(zombieWanderBehaviour);
		
	}
	
	/**
	 * adds limbs to limbList
	 */

	private void initializeLimbs() {
		// TODO Auto-generated method stub
		limbList.add(leftArm);
		limbList.add(rightArm);
		limbList.add(leftLeg);
		limbList.add(rightLeg);
		
	}


	@Override
	/**
	 * 
	 * 
	 */
	// Zombie has a 50% chance of returning a bite attack.
	public IntrinsicWeapon getIntrinsicWeapon() {
		if ((!limbList.contains(rightArm))) {
			if(!limbList.contains(leftArm)) {
				return new IntrinsicWeapon(15, "bites");	
			}
			int biteProbability=rand.nextInt(101);
			if(biteProbability<=75) {
				return new IntrinsicWeapon(15, "bites");	
			}
			
		}
		if(rand.nextBoolean()) {
			return new IntrinsicWeapon(15, "bites");	

		}
		return new IntrinsicWeapon(10, "punches");
	}

	/**
	 * If a Zombie can attack, it will.  If not, it will chase any human within 10 spaces.  
	 * If no humans are close enough it will wander randomly.
	 * 
	 * @param actions list of possible Actions
	 * @param lastAction previous Action, if it was a multiturn action
	 * @param map the map where the current Zombie is
	 * @param display the Display where the Zombie's utterances will be displayed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		
		
		zombieLocation=map.locationOf(this);
		if(legsPresent==0) {
			if(behaviours.contains(zombieHuntBehaviour)) {
				behaviours.remove(behaviours.indexOf(zombieHuntBehaviour));
				behaviours.remove(behaviours.indexOf(zombieWanderBehaviour));
			}
		}
		if(legsPresent==1) {
			if(behaviours.contains(zombieHuntBehaviour)) {
				behaviours.remove(behaviours.indexOf(zombieHuntBehaviour));
				behaviours.remove(behaviours.indexOf(zombieWanderBehaviour));
			}else {
				behaviours.add(zombieHuntBehaviour);
				behaviours.add(zombieWanderBehaviour);
			}
		}
		
		if(hurtThisTurn) {
			int breakLimbProbability=rand.nextInt(101);
			if(breakLimbProbability<=25) {
				dropLimb(display);
			}
			hurtThisTurn=false;
		}
		maybeSayBrains(display,map);
		
		
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			
			if (action != null)
				return action;
		}
		return new DoNothingAction();	
	}
	
	/**
	 * the zombie says a phrase with 10% probability 
	 * @param display displays the string 
	 * @param map the map that actor is currently on
	 */
	private void maybeSayBrains(Display display, GameMap map) {
		// TODO Auto-generated method stub
		int brainsProbability=rand.nextInt(101);
		if(brainsProbability<=10) {
			display.println(new SayAction("Braaaiiinnsss!!!").execute(Zombie.this, map));
		}
	}
	
	/**
	 * called when the actor is hurt and sets hurtThisTurn to true
	 * @param points The amount of damage the actor took
	 */
	@Override
	public void hurt(int points) {
		// TODO Auto-generated method stub
		super.hurt(points);
		hurtThisTurn=true;
		
	}
	/**
	 * zombie drops limbs 
	 * @param display displays limb drop status to the player
	 */


	private void dropLimb(Display display) {
		// TODO Auto-generated method stub
		if(limbList.size()>0) {
			String limbName=limbList.remove(0);
			
			
			if(limbName.equals(leftArm)) {
				zombieLocation.addItem(new CraftableWeapon(limbName,'&', 20, "hits",ItemCapability.CRAFTABLE));

				setArmsPresent(getArmsPresent() - 1);
				display.println(this+" Dropped left Arm due to player's attack!");
			}else if(limbName.equals(rightArm)) {
				zombieLocation.addItem(new CraftableWeapon(limbName,'&', 20, "hits",ItemCapability.CRAFTABLE));

				setArmsPresent(getArmsPresent() - 1);
				display.println(this + " Dropped right Arm due to player's attack!");

			}
			else {
				//Dropped Leg
				zombieLocation.addItem(new CraftableWeapon(limbName,'*', 20, "hits",ItemCapability.CRAFTABLE));

				legsPresent--;
				display.println(this +" Dropped a leg due to player's attack!");
				
			}
			
		}
	}



	public int getArmsPresent() {
		return armsPresent;
	}


	public void setArmsPresent(int armsPresent) {
		this.armsPresent = armsPresent;
	}
}
