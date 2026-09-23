package edu.towson.cis.cosc442.project1.monopoly;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;


public class Player {
	//the key of colorGroups is the name of the color group.
	private Hashtable<String, Integer> colorGroups = new Hashtable<String, Integer>();
	private boolean inJail;
	private int money;
	private String name;

	private Cell position;
	private ArrayList<PropertyCell> properties = new ArrayList<PropertyCell>();
	private ArrayList<Cell> railroads = new ArrayList<Cell>();
	private ArrayList<Cell> utilities = new ArrayList<Cell>();
	
	/**
	 * Constructs a new Player and positions them at the 'Go' cell if the game board is available.
	 */
	public Player() {
		GameBoard gb = GameMaster.instance().getGameBoard();
		inJail = false;
		if(gb != null) {
			position = gb.queryCell("Go");
		}
	}

    /**
     * Assigns the player as the owner of the given property and deducts the specified amount from the player's money.
     * @param property The property cell to be bought.
     * @param amount The amount of money paid for the property.
     */
    public void buyProperty(Cell property, int amount) {
        property.setTheOwner(this);
        addPropertyToPlayer(property);
        addRailroadProperty(property);
        addUtilityProperty(property);
        setMoney(getMoney() - amount);
    }

	/**
	 * Adds the given property to the player's list if it is a PropertyCell and updates the color group count accordingly.
	 * @param property The property cell to add to the player.
	 */
	private void addPropertyToPlayer(Cell property) {
		if(property instanceof PropertyCell) {
            PropertyCell cell = (PropertyCell)property;
            properties.add(cell);
            colorGroups.put(
                    cell.getColorGroup(), 
                    getPropertyNumberForColor(cell.getColorGroup())+1);
        }
	}

	/**
	 * Adds the given property to the player's list of railroads if it is a RailRoadCell and updates the railroad count.
	 * @param property The railroad cell to add to the player.
	 */
	private void addRailroadProperty(Cell property) {
		if(property instanceof RailRoadCell) {
            railroads.add(property);
            colorGroups.put(
                    RailRoadCell.COLOR_GROUP, 
                    getPropertyNumberForColor(RailRoadCell.COLOR_GROUP)+1);
        }
	}

	/**
	 * Adds the given property to the player's list of utilities if it is a UtilityCell and updates the utility count.
	 * @param property The utility cell to add to the player.
	 */
	private void addUtilityProperty(Cell property) {
		if(property instanceof UtilityCell) {
            utilities.add(property);
            colorGroups.put(
                    UtilityCell.COLOR_GROUP, 
                    getPropertyNumberForColor(UtilityCell.COLOR_GROUP)+1);
        }
	}
	
	/**
	 * Determines if the player can buy houses by checking if they have any monopolies.
	 * @return True if the player owns at least one monopoly; otherwise false.
	 */
	public boolean canBuyHouse() {
		return (getMonopolies().length != 0);
	}

	/**
	 * Checks if the player owns the property with the specified name.
	 * @param property Name of the property to check ownership of.
	 * @return True if the player owns the property; otherwise false.
	 */
	public boolean checkProperty(String property) {
		for(int i=0;i<properties.size();i++) {
			Cell cell = properties.get(i);
			if(cell.getName().equals(property)) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Transfers ownership of all properties from this player to the specified player, or clears them if null.
	 * @param player The player to receive the properties, or null to clear ownership.
	 */
	public void exchangeProperty(Player player) {
		for(int i = 0; i < getPropertyNumber(); i++ ) {
			PropertyCell cell = getProperty(i);
			cell.setTheOwner(player);
			if(player == null) {
				cell.setAvailable(true);
				cell.setNumHouses(0);
			}
			else {
				player.properties.add(cell);
				colorGroups.put(
						cell.getColorGroup(), 
						getPropertyNumberForColor(cell.getColorGroup())+1);
			}
		}
		properties.clear();
	}
    
    /**
     * Returns an array of all properties, utilities, and railroads owned by the player.
     * @return An array containing all property, railroad, and utility cells owned by the player.
     */
    public Cell[] getAllProperties() {
        ArrayList<Cell> list = new ArrayList<Cell>();
        list.addAll(properties);
        list.addAll(utilities);
        list.addAll(railroads);
        return (Cell[])list.toArray(new Cell[list.size()]);
    }

	/**
	 * Gets the amount of money the player currently has.
	 * @return The player's current money amount.
	 */
	public int getMoney() {
		return this.money;
	}
	
	/**
	 * Returns the list of color groups for which the player owns all properties, constituting monopolies.
	 * @return An array of color group names representing the player's monopolies.
	 */
	public String[] getMonopolies() {
		ArrayList<String> monopolies = new ArrayList<String>();
		Enumeration<String> colors = colorGroups.keys();
		while(colors.hasMoreElements()) {
			String color = colors.nextElement();
            if(!(color.equals(RailRoadCell.COLOR_GROUP)) && !(color.equals(UtilityCell.COLOR_GROUP))) {
    			Integer num = colorGroups.get(color);
    			GameBoard gameBoard = GameMaster.instance().getGameBoard();
    			if(num.intValue() == gameBoard.getPropertyNumberForColor(color)) {
    				monopolies.add(color);
    			}
            }
		}
		return (String[])monopolies.toArray(new String[monopolies.size()]);
	}

	/**
	 * Returns the name of the player.
	 * @return The player's name as a string.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Allows the player to pay the jail bail and get out of jail, updating bankruptcy status and GUI accordingly.
	 */
	public void getOutOfJail() {
		money -= JailCell.BAIL;
		if(isBankrupt()) {
			money = 0;
			exchangeProperty(null);
		}
		inJail = false;
		GameMaster.instance().updateGUI();
	}

	/**
	 * Returns the current board position of the player.
	 * @return The Cell representing the player's current position.
	 */
	public Cell getPosition() {
		return this.position;
	}
	
	/**
	 * Returns the player's property at the specified index.
	 * @param index The index of the property to retrieve.
	 * @return The PropertyCell at the given index owned by the player.
	 */
	public PropertyCell getProperty(int index) {
		return properties.get(index);
	}
	
	/**
	 * Returns the number of properties the player currently owns.
	 * @return The count of properties owned by the player.
	 */
	public int getPropertyNumber() {
		return properties.size();
	}

	/**
	 * Returns the number of properties the player owns of the specified color group.
	 * @param name The color group name to query.
	 * @return The number of properties owned in the given color group.
	 */
	private int getPropertyNumberForColor(String name) {
		Integer number = colorGroups.get(name);
		if(number != null) {
			return number.intValue();
		}
		return 0;
	}

	/**
	 * Checks if the player is bankrupt (money less than or equal to zero).
	 * @return True if the player has no money remaining; otherwise false.
	 */
	public boolean isBankrupt() {
		return money <= 0;
	}

	/**
	 * Indicates whether the player is currently in jail.
	 * @return True if the player is in jail; otherwise false.
	 */
	public boolean isInJail() {
		return inJail;
	}

	/**
	 * Returns the number of railroad properties the player owns.
	 * @return The count of owned railroad cells.
	 */
	public int numberOfRR() {
		return getPropertyNumberForColor(RailRoadCell.COLOR_GROUP);
	}

	/**
	 * Returns the number of utility properties the player owns.
	 * @return The count of owned utility cells.
	 */
	public int numberOfUtil() {
		return getPropertyNumberForColor(UtilityCell.COLOR_GROUP);
	}
	
	/**
	 * Pays rent to another player and updates ownership if this player becomes bankrupt.
	 * @param owner The player to whom rent is paid.
	 * @param rentValue The amount of rent to pay.
	 */
	public void payRentTo(Player owner, int rentValue) {
		if(money < rentValue) {
			owner.money += money;
			money -= rentValue;
		}
		else {
			money -= rentValue;
			owner.money +=rentValue;
		}
		if(isBankrupt()) {
			money = 0;
			exchangeProperty(owner);
		}
	}
	
	/**
	 * Attempts to purchase the property at the player's current position if it is available.
	 */
	public void purchase() {
		if(getPosition().isAvailable()) {
			Cell c = getPosition();
			c.setAvailable(false);
			if(c instanceof PropertyCell) {
				PropertyCell cell = (PropertyCell)c;
				purchaseProperty(cell);
			}
			if(c instanceof RailRoadCell) {
				RailRoadCell cell = (RailRoadCell)c;
				purchaseRailRoad(cell);
			}
			if(c instanceof UtilityCell) {
				UtilityCell cell = (UtilityCell)c;
				purchaseUtility(cell);
			}
		}
	}
	
	/**
	 * Purchases a specified number of houses for all properties in the given monopoly color group if the player has enough money.
	 * @param selectedMonopoly The color group name where houses will be purchased.
	 * @param houses The number of houses to buy on each property.
	 */
	public void purchaseHouse(String selectedMonopoly, int houses) {
		GameBoard gb = GameMaster.instance().getGameBoard();
		PropertyCell[] cells = gb.getPropertiesInMonopoly(selectedMonopoly);
		if((money >= (cells.length * (cells[0].getHousePrice() * houses)))) {
			updatePropertyHouses(houses, cells);
		}
	}

	/**
	 * Updates the number of houses on the given properties by adding the specified houses if within allowed limits and adjusts the player's money.
	 * @param houses The number of houses to add to each property.
	 * @param cells Array of properties to update houses on.
	 */
	private void updatePropertyHouses(int houses, PropertyCell[] cells) {
		for(int i = 0; i < cells.length; i++) {
			int newNumber = cells[i].getNumHouses() + houses;
			if (newNumber <= 5) {
				cells[i].setNumHouses(newNumber);
				this.setMoney(money - (cells[i].getHousePrice() * houses));
				GameMaster.instance().updateGUI();
			}
		}
	}
	
	/**
	 * Purchases the specified property cell by invoking the buyProperty method with its price.
	 * @param cell The property cell to purchase.
	 */
	private void purchaseProperty(PropertyCell cell) {
        buyProperty(cell, cell.getPrice());
	}

	/**
	 * Purchases the specified railroad cell by invoking the buyProperty method with its price.
	 * @param cell The railroad cell to purchase.
	 */
	private void purchaseRailRoad(RailRoadCell cell) {
	    buyProperty(cell, cell.getPrice());
	}

	/**
	 * Purchases the specified utility cell by invoking the buyProperty method with its price.
	 * @param cell The utility cell to purchase.
	 */
	private void purchaseUtility(UtilityCell cell) {
	    buyProperty(cell, cell.getPrice());
	}

    /**
     * Sells the specified property and adds the amount to the player's money.
     * @param property The property cell to sell.
     * @param amount The amount of money to receive from the sale.
     */
    public void sellProperty(Cell property, int amount) {
        property.setTheOwner(null);
        if(property instanceof PropertyCell) {
            properties.remove(property);
        }
        if(property instanceof RailRoadCell) {
            railroads.remove(property);
        }
        if(property instanceof UtilityCell) {
            utilities.remove(property);
        }
        setMoney(getMoney() + amount);
    }

	/**
	 * Sets the jail status of the player.
	 * @param inJail True if the player is to be marked in jail; false otherwise.
	 */
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	/**
	 * Sets the player's money amount to the specified value.
	 * @param money The new money amount to set.
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Sets the player's name to the specified string.
	 * @param name The new name for the player.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the player's position on the board to the specified cell.
	 * @param newPosition The cell representing the new position on the board.
	 */
	public void setPosition(Cell newPosition) {
		this.position = newPosition;
	}

    /**
     * Returns the player's name as a string representation.
     * @return The player's name.
     */
    public String toString() {
        return name;
    }
    
    /**
     * Resets the player's properties, railroads, and utilities by clearing their respective lists.
     */
    public void resetProperty() {
    	properties = new ArrayList<PropertyCell>();
    	railroads = new ArrayList<Cell>();
    	utilities = new ArrayList<Cell>();
	}
}
