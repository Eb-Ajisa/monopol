package edu.towson.cis.cosc442.project1.monopoly;

public class MockRespondDialog implements RespondDialog {
    /**
     * Constructs a mock respond dialog initialized with the specified trade deal.
     * @param deal the TradeDeal object associated with this dialog
     */
    public MockRespondDialog(TradeDeal deal) {
    }

    /**
     * Returns a fixed mock response indicating agreement to the trade.
     * @return a boolean value always true to simulate acceptance
     */
    public boolean getResponse() {
        return true;
    }
}
