package edu.towson.cis.cosc442.project1.monopoly;

public class RailRoadCell extends Cell {
	private static int baseRent;
	public static String COLOR_GROUP = "RAILROAD";
	private static int price;

	/**
	 * Sets the base rent value for all railroad cells.
	 * @param baseRent the base rent amount to set
	 */
	public static void setBaseRent(int baseRent) {
		RailRoadCell.baseRent = baseRent;
	}

	/**
	 * Sets the purchase price for all railroad cells.
	 * @param price the price amount to set
	 */
	public static void setPrice(int price) {
		RailRoadCell.price = price;
	}
	
	@Override
	/**
	 * Returns the purchase price of the railroad cell.
	 * @return the price of the railroad cell
	 */
	public int getPrice() {
		return RailRoadCell.price;
	}

	/**
	 * Calculates and returns the rent owed based on the number of railroads owned by the owner.
	 * @return the calculated rent amount for this railroad cell
	 */
	public int getRent() {
		return RailRoadCell.baseRent * (int)Math.pow(2, theOwner.numberOfRR() - 1);
	}
	
	/**
	 * Executes the action when a player lands on this railroad cell, charging rent if owned by another player.
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
}
