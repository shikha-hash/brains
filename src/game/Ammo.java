package game;

public class Ammo extends PortableItem{
	
	private int clipsize = 0;
	
	/**
	 * Class which represents ammunition for guns in the game.
	 * @param clipSize the number of bullets in this ammunition package
	 * @author catopoynton
	 */
	
	public Ammo(int clipSize) {
		super("Ammo", 'A');
		this.clipsize = clipSize;
		
	}
	/**
	 * @return the clipsize of this piece of ammunition
	 */
	public int getClipSize() {
		return clipsize;
	}
}
