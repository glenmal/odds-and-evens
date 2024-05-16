package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface AI {
  /**
   * A method that all linked classes (AI difficulties) have to implement and use to generate an
   * integer (0 - 5) depending on the strategy used
   *
   * @param roundCount the number of rounds in current active game
   * @param evenCount the number of even numbers the user played in active game
   * @param oddCount the number of odd numbers the user played in active game
   * @param choice the win condition for the user (EVEN or ODD)
   * @return the number of "fingers" (integer from 0 - 5) that the bot shows
   */
  Integer botOutput(Integer roundCount, Integer evenCount, Integer oddCount, Choice choice);
}
