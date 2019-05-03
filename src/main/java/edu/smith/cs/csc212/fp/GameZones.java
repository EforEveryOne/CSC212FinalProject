package edu.smith.cs.csc212.fp;

import java.util.HashMap;
import java.util.Map;

import edu.smith.cs.csc212.fp.Place;
import edu.smith.cs.csc212.fp.Exit;
//import edu.smith.cs.csc212.fp.SecretExit;

public class GameZones {
	
	
private Map<String, Place> places = new HashMap<>();
	
	/**
	 * Where should the player start?
	 */
	public String getStart() {
		return "town";
	}
	
	
	public GameZones() {
//		1st string = id, 2nd = description, 3rd = options
		Place town = insert(
				Place.create("town", "You're in a town. People seem busy. A nearby Shop and Tavern stand out to you. ",
						"\nOptions: [0], [1], [2], [search], [player]"));
		town.addExit(new Exit("shop", "Go to Shop. "));
		town.addExit(new Exit("tavern", "Go to Tavern. "));
		town.addExit(new Exit("wilderness", "An old dusty road heading out of town... "));
		
		Place tavern = insert(
				Place.create("tavern", "This is the tavern. ", "\nOptions: [0], [search], [player], [sleep] "));
		tavern.addExit(new Exit("town", "Back to town. "));
		
		Place shop = insert(
				Place.create("shop", "This is the shop. ", "\nOptions: [0], [search], [player], TODO:[buy] + [sell] "));
		shop.addExit(new Exit("town", "Back to Town. "));
		
		Place wilderness = insert(
				Place.create("wilderness", "This is outside of town, it's dangerous...", "\nOptions: [0], [search], [player], [explore] "));
		wilderness.addExit(new Exit("town", "Back to Town. "));
		
		
		
		
//		tavern.addExit(new Exit("", ""));
		
		checkAllExitsGoSomewhere();
	
	
	}

	protected Place insert(Place p) {
		places.put(p.getId(), p);
		return p;
	}
	
	public Place getPlace(String id) {
		return this.places.get(id);		
	}
	
	
	private void checkAllExitsGoSomewhere() {
		boolean missing = false;
		// For every place:
		for (Place p : places.values()) {
			// For every exit from that place:
			for (Exit x : p.getVisibleExits()) {
				// That exit goes to somewhere that exists!
				if (!places.containsKey(x.getTarget())) {
					// Don't leave immediately, but check everything all at once.
					missing = true;
					// Print every exit with a missing place:
					System.err.println("Found exit pointing at " + x.getTarget() + " which does not exist as a place.");
				}
			}
		}
		
		// Now that we've checked every exit for every place, crash if we printed any errors.
		if (missing) {
			throw new RuntimeException("You have some exits to nowhere!");
		}
	}
	
	
	
}
