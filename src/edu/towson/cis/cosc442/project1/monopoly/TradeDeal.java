package edu.towson.cis.cosc442.project1.monopoly;

public class TradeDeal {
    private int amount;
    private int playerIndex;
    private String propertyName;

    /**
     * Returns the amount of money involved in the trade deal.
     * @return the trade deal amount as an integer
     */
    public int getAmount() {
        return amount;
    }
    
    /**
     * Returns the index of the player who is selling the property.
     * @return the seller player's index as an integer
     */
    public int getPlayerIndex() {
        return playerIndex;
    }
    
    /**
     * Returns the name of the property involved in the trade deal.
     * @return the property name as a String
     */
    public String getPropertyName() {
        return propertyName;
    }
    
    /**
     * Constructs a formatted message describing the trade offer and prompts the seller for a response.
     * @return the trade offer message as a String
     */
    public String makeMessage() {
        return GameMaster.instance().getCurrentPlayer() + 
        	" wishes to purchase " +
        	propertyName + " from " + 
        	GameMaster.instance().getPlayer(playerIndex) +
        	" for " + amount + ".  " + 
        	GameMaster.instance().getPlayer(playerIndex) +
        	", do you wish to trade your property?";
    }
    
    /**
     * Sets the amount of money involved in the trade deal.
     * @param amount the amount to set for this trade deal
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    /**
     * Sets the name of the property involved in the trade deal.
     * @param propertyName the property name to set for this trade deal
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
    /**
     * Sets the index of the player who is selling the property in this trade deal.
     * @param playerIndex the player index to set as the seller
     */
    public void setSellerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
}
