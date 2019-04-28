package edu.smith.cs.csc212.fp;

import java.util.ArrayList;
import java.util.List;

import edu.smith.cs.csc212.fp.Exit;

//JJ code
public class Place {
	/**
	 * This is a list of places we can get to from this place.
	 */
	private List<Exit> exits;

	/**
	 * This is the identifier of the place.
	 */
	private String id;
	/**
	 * What to tell the user about this place.
	 */
	private String description;
	/**
	 * Whether reaching this place ends the game.
	 */
	private boolean terminal;
	
	/**
	 * Internal only constructor for Place. Use {@link #create(String, String)} or {@link #terminal(String, String)} instead.
	 * @param id - the internal id of this place.
	 * @param description - the user-facing description of the place.
	 * @param terminal - whether this place ends the game.
	 */
	private Place(String id, String description, boolean terminal) {
		this.id = id;
		this.description = description;
		this.exits = new ArrayList<>();
		this.terminal = terminal;
	}
	}