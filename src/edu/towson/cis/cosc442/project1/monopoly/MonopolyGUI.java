package edu.towson.cis.cosc442.project1.monopoly;

public interface MonopolyGUI {
	/**
	 * Enables the end turn button for the specified player.
	 * @param playerIndex The index of the player for whom to enable the end turn button.
	 */
	public void enableEndTurnBtn(int playerIndex);
	/**
	 * Enables the user interface controls for the specified player's turn.
	 * @param playerIndex The index of the player whose turn is being enabled.
	 */
	public void enablePlayerTurn(int playerIndex);
	/**
	 * Enables the purchase button for the specified player.
	 * @param playerIndex The index of the player for whom to enable the purchase button.
	 */
	public void enablePurchaseBtn(int playerIndex);
	/**
	 * Retrieves the current dice roll results as an array of integers.
	 * @return An int array containing the values of the dice rolled.
	 */
	public int[] getDiceRoll();
    /**
     * Determines if the draw card button is currently enabled.
     * @return True if the draw card button is enabled; false otherwise.
     */
    public boolean isDrawCardButtonEnabled();
    /**
     * Checks whether the end turn button is enabled.
     * @return True if the end turn button is enabled; false otherwise.
     */
    public boolean isEndTurnButtonEnabled();
	/**
	 * Checks whether the get out of jail button is enabled.
	 * @return True if the get out of jail button is enabled; false otherwise.
	 */
	public boolean isGetOutOfJailButtonEnabled();
    /**
     * Checks if the trade button is enabled for the specified player.
     * @param i The index of the player to check trade button status for.
     * @return True if the trade button is enabled for the player; false otherwise.
     */
    public boolean isTradeButtonEnabled(int i);
	/**
	 * Moves the player from one board position to another.
	 * @param index The index of the player to move.
	 * @param from The starting position on the board.
	 * @param to The destination position on the board.
	 */
	public void movePlayer(int index, int from, int to);
    /**
     * Opens a dialog to respond to a trade deal.
     * @param deal The trade deal to respond to.
     * @return A RespondDialog interface for handling the trade response.
     */
    public RespondDialog openRespondDialog(TradeDeal deal);
    /**
     * Opens the trade dialog for initiating a trade between players.
     * @return A TradeDialog interface for conducting trades.
     */
    public TradeDialog openTradeDialog();
    /**
     * Enables or disables the buy house option in the UI.
     * @param b True to enable buy house; false to disable.
     */
    public void setBuyHouseEnabled(boolean b);
    /**
     * Enables or disables the draw card button in the UI.
     * @param b True to enable draw card; false to disable.
     */
    public void setDrawCardEnabled(boolean b);
    /**
     * Enables or disables the end turn button.
     * @param enabled True to enable end turn; false to disable.
     */
    public void setEndTurnEnabled(boolean enabled);
    /**
     * Enables or disables the get out of jail button.
     * @param b True to enable get out of jail; false to disable.
     */
    public void setGetOutOfJailEnabled(boolean b);
    /**
     * Enables or disables the purchase property button.
     * @param enabled True to enable purchase property; false to disable.
     */
    public void setPurchasePropertyEnabled(boolean enabled);
    /**
     * Enables or disables the roll dice button.
     * @param b True to enable rolling dice; false to disable.
     */
    public void setRollDiceEnabled(boolean b);
    /**
     * Enables or disables the trade button for a specific player.
     * @param index The player index for which to set the trade button state.
     * @param b True to enable trade; false to disable.
     */
    public void setTradeEnabled(int index, boolean b);
    /**
     * Displays a dialog to allow the specified player to buy houses.
     * @param currentPlayer The player who may purchase houses.
     */
    public void showBuyHouseDialog(Player currentPlayer);
    /**
     * Displays a message to the user.
     * @param string The message text to display.
     */
    public void showMessage(String string);
	/**
	 * Shows the dice roll result for utilities.
	 * @return An integer representing the utility dice roll result.
	 */
	public int showUtilDiceRoll();
	/**
	 * Starts the game and initializes the user interface.
	 */
	public void startGame();
	/**
	 * Refreshes the user interface to reflect the current game state.
	 */
	public void update();
}
