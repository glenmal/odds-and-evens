package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {

  /**
   * Factory method that gets the difficulty input by the user and returns an AI that uses a
   * different strategy depending on its respective difficulty
   *
   * @param difficulty the difficulty inputted by the user (EASY, MEDIUM, HARD)
   * @return the AI with the rated difficulty
   */
  public static AI generateAI(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAI();
      case MEDIUM:
        return new MediumAI();
      case HARD:
        return new HardAI();
      default:
        return null;
    }
  }
}
