package edu.towson.cis.cosc442.project1.monopoly;

public class GoToJailCell extends Cell {
	
	/**
	 * Constructs a GoToJailCell and sets its name to "Go to Jail".
	 */
	public GoToJailCell() {
		setName("Go to Jail");
	}

	/**
	 * Executes the action of sending the current player to jail when landing on this cell.
	 */
	public void playAction() {
		Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		GameMaster.instance().getGameBoard().queryCell("Jail");
		GameMaster.instance().sendToJail(currentPlayer);
	}
}
