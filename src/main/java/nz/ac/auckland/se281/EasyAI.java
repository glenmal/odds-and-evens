package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAI implements AI {
  // AI set to Easy difficulty
  Integer botOutput;
  Strategy strategy;

  EasyAI() {
    strategy = new RandomStrategy();
  }

  // outputs using the Random Strategy only
  public Integer botOutput(Integer roundCount, Integer evenCount, Integer oddCount, Choice choice) {
    botOutput = strategy.strategyOutput(null, null, null, null);
    return botOutput;
  }
}
