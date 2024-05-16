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

  // odd or even sum winner into string
  public static String oddsWinner(Integer sum) {
    if (Utils.isEven(sum)) {
      return "EVEN";
    } else {
      return "ODD";
    }
  }

  // converts choice enums to string
  public static String choiceString(Choice choice) {
    switch (choice) {
      case EVEN:
        return "EVEN";
      case ODD:
        return "ODD";
      default:
        return "";
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
