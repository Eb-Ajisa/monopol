package edu.towson.cis.cosc442.project1.monopoly;

public class GoCell extends Cell {
	/**
	 * Constructs a GoCell object and initializes its name to "Go" and availability to false.
	 */
	public GoCell() {
		super.setName("Go");
		setAvailable(false);
	}

	/**
	 * Performs the action associated with landing on the Go cell, currently implemented as an empty method.
	 */
	public void playAction() {
	}
	
	/**
	 * Sets the name of the cell to the given value, currently implemented as an empty method.
	 * @param name the new name to assign to the cell
	 */
	void setName(String name) {
	}
}
