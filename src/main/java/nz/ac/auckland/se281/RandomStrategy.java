package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {
  public Integer strategyOutput() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
