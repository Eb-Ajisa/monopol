package edu.towson.cis.cosc442.project1.monopoly;

import java.util.Random;

public class Die {
	private final Random random = new Random();

	public int getRoll() {
		return random.nextInt(6) + 1;
	}
}
