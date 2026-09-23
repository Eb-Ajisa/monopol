package edu.towson.cis.cosc442.project1.monopoly;

public class MockGUI implements MonopolyGUI {
    private boolean btnDrawCardState;
    private boolean  btnEndTurnState;
    private boolean  btnGetOutOfJailState;
    private boolean[] btnTradeState = new boolean[2];

    /**
     * Enables the 'End Turn' button for the specified player index.
     * @param playerIndex Index of the player for whom to enable the button
     */
    public void enableEndTurnBtn(int playerIndex) {
    }

    /**
     * Enables the interface elements related to the specified player's turn.
     * @param playerIndex Index of the player whose turn is being enabled
     */
    public void enablePlayerTurn(int playerIndex) {
    }

    /**
     * Enables the purchase button for the player identified by the given index.
     * @param playerIndex Index of the player for whom to enable the purchase button
     */
    public void enablePurchaseBtn(int playerIndex) {
    }
	/**
	 * Returns a fixed pair of dice roll values.
	 * @return An array of two integers representing dice roll results.
	 */
	public int[] getDiceRoll() {
		int[] roll = new int[2];
		roll[0] = 2;
		roll[1] = 3;
		return roll;
	}

    /**
     * Checks if the 'Draw Card' button is currently enabled.
     * @return True if the 'Draw Card' button is enabled; false otherwise.
     */
    public boolean isDrawCardButtonEnabled() {
        return btnDrawCardState;
    }

    /**
     * Checks if the 'End Turn' button is currently enabled.
     * @return True if the 'End Turn' button is enabled; false otherwise.
     */
    public boolean isEndTurnButtonEnabled() {
        return btnEndTurnState;
    }
	
	/**
	 * Checks if the 'Get Out of Jail' button is currently enabled.
	 * @return True if the 'Get Out of Jail' button is enabled; false otherwise.
	 */
	public boolean isGetOutOfJailButtonEnabled() {
		return btnGetOutOfJailState;
	}

    /**
     * Checks if the trade button for a given index is enabled.
     * @param i Index of the trade button to check
     * @return True if the trade button at the given index is enabled; false otherwise.
     */
    public boolean isTradeButtonEnabled(int i) {
        return btnTradeState[i];
    }

    /**
     * Moves a player from one position to another on the board.
     * @param index The player index to move
     * @param from The starting position index
     * @param to The destination position index
     */
    public void movePlayer(int index, int from, int to) {
    }

    /**
     * Opens a dialog for responding to a proposed trade deal.
     * @param deal The trade deal to respond to
     * @return A RespondDialog instance for interacting with the trade response.
     */
    public RespondDialog openRespondDialog(TradeDeal deal) {
        return new MockRespondDialog(deal);
    }

    /**
     * Opens a dialog for initiating a trade between players.
     * @return A TradeDialog instance for creating a trade proposal.
     */
    public TradeDialog openTradeDialog() {
        return new MockTradeDialog();
    }

    /**
     * Enables or disables the option to buy a house.
     * @param b True to enable buying houses; false to disable
     */
    public void setBuyHouseEnabled(boolean b) {
    }

    /**
     * Sets the enabled state of the 'Draw Card' button.
     * @param b True to enable the button; false to disable
     */
    public void setDrawCardEnabled(boolean b) {
        btnDrawCardState = b;
    }

    /**
     * Sets whether the 'End Turn' button is enabled.
     * @param enabled True to enable the button; false to disable
     */
    public void setEndTurnEnabled(boolean enabled) {
        btnEndTurnState = enabled;
    }

    /**
     * Sets the enabled state of the 'Get Out of Jail' button.
     * @param b True to enable the button; false to disable
     */
    public void setGetOutOfJailEnabled(boolean b) {
    	this.btnGetOutOfJailState = b;
    }

    /**
     * Enables or disables the property purchase option.
     * @param enabled True to enable purchasing property; false to disable
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
    }

    /**
     * Sets whether the roll dice button is enabled.
     * @param b True to enable rolling dice; false to disable
     */
    public void setRollDiceEnabled(boolean b) {
    }

    /**
     * Enables or disables the trade button for a specific index.
     * @param index Index of the trade button to set
     * @param b True to enable the button; false to disable
     */
    public void setTradeEnabled(int index, boolean b) {
        this.btnTradeState[index] = b;
    }

    /**
     * Displays the dialog for buying a house for the given player.
     * @param currentPlayer The player currently buying a house
     */
    public void showBuyHouseDialog(Player currentPlayer) {
    }

    /**
     * Displays a message to the user.
     * @param string The message text to display
     */
    public void showMessage(String string) {
    }

	/**
	 * Shows a fixed utility dice roll value.
	 * @return An integer representing the utility dice roll value displayed.
	 */
	public int showUtilDiceRoll() {
		return 10;
	}

    /**
     * Starts the game and initializes relevant game state and UI elements.
     */
    public void startGame() {
    }

	/**
	 * Updates the GUI to reflect the current state of the game.
	 */
	public void update() {
	}
}
