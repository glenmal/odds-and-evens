package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {
  public static AI generateAI(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAI();
        // case MEDIUM:

        // case HARD:
      default:
        return null;
    }
  }
}
