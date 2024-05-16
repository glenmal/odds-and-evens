package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface Strategy {
  public Integer strategyOutput(
      Integer roundCount, Integer evenCount, Integer oddCount, Choice choice);
}
