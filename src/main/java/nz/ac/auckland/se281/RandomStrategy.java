package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class RandomStrategy implements Strategy {
  public Integer strategyOutput(
      Integer roundCount, Integer evenCount, Integer oddCount, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
