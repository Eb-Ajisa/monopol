package edu.towson.cis.cosc442.project1.monopoly;


public class JailCard extends Card {
    int type;
    
    /**
     * Constructs a JailCard with the specified card type.
     * @param cardType the type identifier for this JailCard
     */
    public JailCard(int cardType) {
        type = cardType;
    }

    /**
     * Applies the jail action by sending the current player directly to jail without collecting $200.
     */
    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		GameMaster.instance().getGameBoard().queryCell("Jail");
		GameMaster.instance().sendToJail(currentPlayer);
    }

    /**
     * Retrieves the type identifier of this JailCard.
     * @return the integer representing the card type
     */
    public int getCardType() {
        return type;
    }

    /**
     * Provides a label describing the jail card's immediate effect.
     * @return a descriptive string of the card's action
     */
    public String getLabel() {
        return "Go to Jail immediately without collecting" +
        		" $200 when passing the GO cell";
    }
}
