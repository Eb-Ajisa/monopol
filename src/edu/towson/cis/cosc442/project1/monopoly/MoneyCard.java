package edu.towson.cis.cosc442.project1.monopoly;

public class MoneyCard extends Card {
    private int amount;
    private int cardType;
    
    private String label;
    
    /**
     * Constructs a MoneyCard with the specified label, amount, and card type.
     * @param label the descriptive label of the card
     * @param amount the monetary amount associated with the card
     * @param cardType the integer representing the type of the card
     */
    public MoneyCard(String label, int amount, int cardType){
        this.label = label;
        this.amount = amount;
        this.cardType = cardType;
    }

    /**
     * Applies the card's action by adding its amount to the current player's money.
     */
    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		currentPlayer.setMoney(currentPlayer.getMoney() + amount);
    }

    /**
     * Returns the card's type as an integer value.
     * @return the integer representing the card's type
     */
    public int getCardType() {
        return cardType;
    }

    /**
     * Returns the descriptive label of the card.
     * @return the label of the card as a String
     */
    public String getLabel() {
        return label;
    }
}
