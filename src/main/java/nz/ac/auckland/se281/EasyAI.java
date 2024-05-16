package nz.ac.auckland.se281;


public class EasyAI implements AI {
  // AI set to Easy difficulty
  Integer botOutput;
  Strategy strategy;

  EasyAI() {
    strategy = new RandomStrategy();
  }

  // outputs using the Random Strategy only
  public Integer botOutput() {
    botOutput = strategy.strategyOutput();
    return botOutput;
  }
}
