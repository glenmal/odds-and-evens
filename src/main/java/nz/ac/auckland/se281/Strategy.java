package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface Strategy {
  /**
   * Strategy function that all game strategies (Random and Top) must include to provide an output
   * (number of "fingers" the bot shows).
   *
   * @param roundCount the number of rounds in current active game
   * @param evenCount the number of even numbers the user played in active game
   * @param oddCount the number of odd numbers the user played in active game
   * @param choice the win condition for the user (EVEN or ODD)
   * @return the number of "fingers" (integer from 0 - 5) that the bot shows depending on its
   *     strategy
   */
  Integer strategyOutput(Integer roundCount, Integer evenCount, Integer oddCount, Choice choice);
}
