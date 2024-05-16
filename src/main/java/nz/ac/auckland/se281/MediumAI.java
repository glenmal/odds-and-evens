package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAI implements AI {
  // AI set to Easy difficulty
  private Integer botOutput;
  private Strategy strategy;

  MediumAI() {
    strategy = new RandomStrategy();
  }

  /**
   * Medium AI bot that uses random strategy for the first 3 rounds and changes to top strat for the
   * rounds after that
   *
   * @param roundCount the number of rounds in current active game
   * @param evenCount the number of even numbers the user played in active game
   * @param oddCount the number of odd numbers the user played in active game
   * @param choice the win condition for the user (EVEN or ODD)
   * @return the number of "fingers" (integer from 0 - 5) that the bot shows
   */
  public Integer botOutput(Integer roundCount, Integer evenCount, Integer oddCount, Choice choice) {
    // uses random strategy for the first 3 rounds and changes to top strat for the next rounds
    if (roundCount <= 3) {
    } else {
      strategy = new TopStrategy();
    }
    botOutput = strategy.strategyOutput(roundCount, evenCount, oddCount, choice);
    return botOutput;
  }
}
