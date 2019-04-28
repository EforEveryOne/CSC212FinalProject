package edu.smith.cs.csc212.fp;

//JJ code
public class Exit {
	/**
	 * How do we describe this exit to a user, e.g., "A door with a spiderweb."
	 */
	private String description;
	/**
	 * How do we identify the Place that this is going.
	 */
	private String target;
	
	/**
	 * Create a new Exit.
	 * @param target - where it goes.
	 * @param description - how it looks.
	 * @param isSecret 
	 */
	public Exit(String target, String description) {
		this.description = description;
		this.target = target;
	}

}
