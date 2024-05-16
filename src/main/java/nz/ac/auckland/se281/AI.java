package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface AI {
  public Integer botOutput(Integer roundCount, Integer evenCount, Integer oddCount, Choice choice);
}
