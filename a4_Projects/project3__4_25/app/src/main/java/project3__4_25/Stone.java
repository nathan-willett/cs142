package project3__4_25;

// CS 142 Critters
// Authors: Marty Stepp, Stuart Reges and Allison Obourn
//
// Stone objects are displayed as S and always stay put.
// They always pick ROAR in a fight.
//
import java.awt.*;

public class Stone extends Critter {
	// method comment goes here
	public Attack fight(String opponent) {
		return Attack.ROAR;
	}

	// method comment goes here
	public Color getColor() {
		return Color.GRAY;
	}

	// method comment goes here
	public String toString() {
		return "S";
	}
}
