package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAI implements AI {
  // AI set to Easy difficulty
  private Integer botOutput;
  private Strategy strategy;

  EasyAI() {
    strategy = new RandomStrategy();
  }

  /**
   * Easy AI bot instance that only uses the Random Strategy when facing the user
   *
   * @param roundCount the number of rounds in current active game
   * @param evenCount the number of even numbers the user played in active game
   * @param oddCount the number of odd numbers the user played in active game
   * @param choice the win condition for the user (EVEN or ODD)
   * @return the number of "fingers" (integer from 0 - 5) that the bot shows
   */
  public Integer botOutput(Integer roundCount, Integer evenCount, Integer oddCount, Choice choice) {
    botOutput = strategy.strategyOutput(null, null, null, null);
    return botOutput;
  }
}
