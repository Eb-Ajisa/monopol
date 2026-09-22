package edu.towson.cis.cosc442.project1.monopoly;

public abstract class Cell {
	private boolean available = true;
	private String name;
	protected Player theOwner;

	/**
	 * Returns the name of the cell.
	 * @return the name of the cell
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the player who owns this cell.
	 * @return the owner player of the cell
	 */
	public Player getTheOwner() {
		return theOwner;
	}
	
	/**
	 * Returns the price of the cell, defaulting to zero.
	 * @return the price of the cell, or zero if not set
	 */
	public int getPrice() {
		return 0;
	}

	/**
	 * Indicates whether the cell is available for purchase or use.
	 * @return true if the cell is available, false otherwise
	 */
	public boolean isAvailable() {
		return available;
	}
	
	/**
	 * Executes the action triggered when this cell is landed on.
	 */
	public abstract void playAction();

	/**
	 * Sets the availability status of the cell.
	 * @param available the new availability status to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/**
	 * Assigns a name to the cell.
	 * @param name the name to assign to the cell
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the owner of this cell.
	 * @param owner the player to set as the owner
	 */
	public void setTheOwner(Player owner) {
		this.theOwner = owner;
	}
    
    /**
     * Returns the string representation of the cell, which is its name.
     * @return the name of the cell as a string
     */
    public String toString() {
        return name;
    }
}
