package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public enum Inputs {
  ZERO,
  ONE,
  TWO,
  THREE,
  FOUR,
  FIVE;

  // checks if there is a wrong number inputted
  public static Boolean checkFingerErrors(String input) {
    switch (input) {
      case "0":
      case "1":
      case "2":
      case "3":
      case "4":
      case "5":
        return false;
      default:
        return true;
    }
  }

  // converts choice enums to String
  public static String stringWinner(Integer sum) {
    if (Utils.isEven(sum)) {
      return "EVEN";
    } else {
      return "ODD";
    }
  }

  // calculates win and checks if player wins
  public static Boolean winCalc(Integer playerFingers, Integer botFingers, Choice choice) {
    Integer sum = playerFingers + botFingers;
    switch (choice) {
      case EVEN:
        if (Utils.isEven(sum)) {
          return true;
        } else {
          return false;
        }
      case ODD:
        if (!Utils.isEven(sum)) {
          return true;
        } else {
          return false;
        }
    }
    return null;
  }
}
