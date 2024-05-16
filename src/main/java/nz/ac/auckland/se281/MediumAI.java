package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAI implements AI {
  // AI set to Easy difficulty
  Integer botOutput;
  Strategy strategy;

  MediumAI() {
    strategy = new RandomStrategy();
  }

  // outputs using the Random Strategy only
  public Integer botOutput(Integer roundCount, Integer evenCount, Integer oddCount, Choice choice) {
    if (roundCount <= 3) {
    } else {
      strategy = new TopStrategy();
    }
    botOutput = strategy.strategyOutput(roundCount, evenCount, oddCount, choice);
    return botOutput;
  }
}
