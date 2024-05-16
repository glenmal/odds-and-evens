package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class RandomStrategy implements Strategy {
  /**
   * Strategy that chooses a random integer between 0 - 5 inclusive for the AI to use.
   *
   * @param roundCount the number of rounds in current active game
   * @param evenCount the number of even numbers the user played in active game
   * @param oddCount the number of odd numbers the user played in active game
   * @param choice the win condition for the user (EVEN or ODD)
   * @return the number of "fingers" (integer from 0 - 5) that the bot shows if it uses this
   *     strategy
   */
  public Integer strategyOutput(
      Integer roundCount, Integer evenCount, Integer oddCount, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
