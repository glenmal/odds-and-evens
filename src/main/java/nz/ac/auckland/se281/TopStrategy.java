package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  /**
   * top strategy and chooses the random strategy for the first 3 rounds and then chooses what the
   * player chooses based on what number the user chooses more often and the win condition
   *
   * @param roundCount the number of rounds in current active game
   * @param evenCount the number of even numbers the user played in active game
   * @param oddCount the number of odd numbers the user played in active game
   * @param choice the win condition for the user (EVEN or ODD)
   * @return the number of "fingers" (integer from 0 - 5) that the bot shows depending on its
   *     strategy
   */
  public Integer strategyOutput(
      Integer roundCount, Integer evenCount, Integer oddCount, Choice choice) {
    switch (choice) {
      case EVEN:
        if (oddCount > evenCount) {
          return Utils.getRandomEvenNumber();
        } else if (evenCount > oddCount) {
          return Utils.getRandomOddNumber();
        } else {
          return Utils.getRandomNumberRange(0, 5);
        }
      case ODD:
        if (oddCount > evenCount) {
          return Utils.getRandomOddNumber();
        } else if (evenCount > oddCount) {
          return Utils.getRandomEvenNumber();
        } else {
          return Utils.getRandomNumberRange(0, 5);
        }
      default:
        return null;
    }
  }
}
