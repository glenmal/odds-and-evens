package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardAI implements AI {
  // AI set to Easy difficulty
  Integer botOutput;
  Strategy strategy;
  Boolean lastWin;

  HardAI() {
    strategy = new RandomStrategy();
    lastWin = false;
  }

  // outputs using the Random Strategy only
  public Integer botOutput(Integer roundCount, Integer evenCount, Integer oddCount, Choice choice) {
    if (roundCount <= 3) {
    } else if (!lastWin) {
      strategy = new TopStrategy();
    } else {
      strategy = new RandomStrategy();
    }
    botOutput = strategy.strategyOutput(roundCount, evenCount, oddCount, choice);
    return botOutput;
  }

  // sets true if bot won last round, else sets to false
  public void setDidLastWin(Boolean lastWin) {
    this.lastWin = lastWin;
  }
}
