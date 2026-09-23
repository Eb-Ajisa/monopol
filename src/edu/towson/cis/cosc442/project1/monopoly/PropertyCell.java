package edu.towson.cis.cosc442.project1.monopoly;

public class PropertyCell extends Cell {
	private String colorGroup;
	private int housePrice;
	private int numHouses;
	private int rent;
	private int sellPrice;

	/**
	 * Returns the color group to which this property cell belongs.
	 * @return The color group of the property cell.
	 */
	public String getColorGroup() {
		return colorGroup;
	}

	/**
	 * Returns the price for purchasing a house on this property.
	 * @return The cost of a house on this property.
	 */
	public int getHousePrice() {
		return housePrice;
	}

	/**
	 * Returns the number of houses currently built on this property.
	 * @return The count of houses on the property.
	 */
	public int getNumHouses() {
		return numHouses;
	}
    
    /**
     * Returns the selling price of this property.
     * @return The sell price of the property.
     */
    @Override
    public int getPrice() {
		return sellPrice;
	}

	/**
	 * Calculates and returns the rent owed for landing on this property, considering monopolies and houses.
	 * @return The calculated rent amount for the property.
	 */
	public int getRent() {
		int rentToCharge = rent;
		String [] monopolies = theOwner.getMonopolies();
		rentToCharge = calculateMonopoliesRent(rentToCharge, monopolies);
		if(numHouses > 0) {
			rentToCharge = rent * (numHouses + 1);
		}
		return rentToCharge;
	}

	/**
	 * Calculates modified rent if the property is part of any monopoly color group.
	 * @param rentToCharge The base rent amount to potentially modify.
	 * @param monopolies Array of monopoly color groups owned by the player.
	 * @return The rent amount adjusted for monopolies.
	 */
	private int calculateMonopoliesRent(int rentToCharge, String[] monopolies) {
		for(int i = 0; i < monopolies.length; i++) {
			if(monopolies[i].equals(colorGroup)) {
				rentToCharge = rent * 2;
			}
		}
		return rentToCharge;
	}

	/**
	 * Executes the action that occurs when a player lands on this property, including rent payment if owned by another player.
	 */
	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(theOwner != currentPlayer) {
				currentPlayer.payRentTo(theOwner, getRent());
			}
		}
	}

	/**
	 * Sets the color group for this property.
	 * @param colorGroup The color group to assign to the property.
	 */
	public void setColorGroup(String colorGroup) {
		this.colorGroup = colorGroup;
	}

	/**
	 * Sets the price to build a house on this property.
	 * @param housePrice The price for purchasing a house.
	 */
	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}

	/**
	 * Sets the number of houses currently built on this property.
	 * @param numHouses The number of houses to set on the property.
	 */
	public void setNumHouses(int numHouses) {
		this.numHouses = numHouses;
	}

	/**
	 * Sets the selling price of this property.
	 * @param sellPrice The sell price to assign to the property.
	 */
	public void setPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	/**
	 * Sets the base rent amount for this property.
	 * @param rent The rent amount to assign to the property.
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}
}
