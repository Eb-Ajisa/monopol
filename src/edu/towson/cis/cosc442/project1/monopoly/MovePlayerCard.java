package edu.towson.cis.cosc442.project1.monopoly;

import java.util.logging.Logger;
import java.util.logging.Level;

public class MovePlayerCard extends Card {
    
    private static final Logger LOGGER = Logger.getLogger(MovePlayerCard.class.getName());
    private String destination;
    private int type;

    /**
     * Constructs a MovePlayerCard specifying the destination and the card type.
     * @param destination the name of the destination cell to move the player to
     * @param cardType the type identifier of this card
     */
    public MovePlayerCard(String destination, int cardType) {
        this.destination = destination;
        this.type = cardType;
    }

    /**
     * Applies the card's action by moving the current player to the specified destination cell.
     */
    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
        Cell currentPosition = currentPlayer.getPosition();
        int newCell = GameMaster.instance().getGameBoard().queryCellIndex(destination);
        int currentCell = GameMaster.instance().getGameBoard().queryCellIndex(currentPosition.getName());
        int diceValue = 0;
        if(currentCell > newCell) {
            diceValue = (GameMaster.instance().getGameBoard().getCellNumber() + 
                    (newCell - currentCell));
        }
        else {
            diceValue = newCell - currentCell;
        }
        LOGGER.log(Level.FINE, "Moving player by {0} spaces.", diceValue);
        GameMaster.instance().movePlayer(currentPlayer, diceValue);
    }

    /**
     * Returns the integer representing this card's type.
     * @return the card type as an integer
     */
    public int getCardType() {
        return type;
    }

    /**
     * Provides a descriptive label indicating the destination cell of this move card.
     * @return a string label describing the card's movement destination
     */
    public String getLabel() {
        return "Go to " + destination;
    }

}
