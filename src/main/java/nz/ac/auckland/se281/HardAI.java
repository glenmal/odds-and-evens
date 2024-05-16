package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardAI implements AI {
  // AI set to Easy difficulty
  private Integer botOutput;
  private Strategy strategy;
  private Boolean lastWin;

  HardAI() {
    strategy = new RandomStrategy();
    lastWin = false;
  }

  /**
   * Hard AI bot instance that uses Random Strategy for the first 3 rounds and from the 4 round
   * onwards, it changes strategy between Top and Random depending on if it won the previous round
   *
   * @param roundCount the number of rounds in current active game
   * @param evenCount the number of even numbers the user played in active game
   * @param oddCount the number of odd numbers the user played in active game
   * @param choice the win condition for the user (EVEN or ODD)
   * @return the number of "fingers" (integer from 0 - 5) that the bot shows
   */
  public Integer botOutput(Integer roundCount, Integer evenCount, Integer oddCount, Choice choice) {
    // uses the round count to indicate if it should switch strategies
    if (roundCount <= 3) {
    } else if (!lastWin) {
      strategy = new TopStrategy();
    } else {
      strategy = new RandomStrategy();
    }
    botOutput = strategy.strategyOutput(roundCount, evenCount, oddCount, choice);
    return botOutput;
  }

  /**
   * @param lastWin boolean statement to tell the bot if it won the previous round of odds and evens
   *     (true = won last round, false = lost last round)
   */
  public void setDidLastWin(Boolean lastWin) {
    this.lastWin = lastWin;
  }
}
