package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public enum Inputs {
  ZERO,
  ONE,
  TWO,
  THREE,
  FOUR,
  FIVE;

  /**
   * Function that checks if the user inputted a valid integer number of fingers (0 - 5)
   *
   * @param input the number of fingers the use inputs (0 - 5)
   * @return boolean true = invalid input (not integer between 0 and 5 inclusive), false = valid
   *     input
   */
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

  /**
   * Function that returns a string depending on the sum is even or odd
   *
   * @param sum the sum of both the bot "fingers" and the user's fingers
   * @return string if sum is even or odd
   */
  public static String oddsWinner(Integer sum) {
    if (Utils.isEven(sum)) {
      return "EVEN";
    } else {
      return "ODD";
    }
  }

  /**
   * Function that determines whether the user or the both wins, depending on what is the win
   * condition is for the user (ODD or EVEN)
   *
   * @param playerFingers the input from the user for the number of fingers they choose
   * @param botFingers the number of "fingers" the bot generates
   * @param choice the win condition the user chooses (EVEN or ODD)
   * @return boolean true = user won, false = bot won
   */
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
