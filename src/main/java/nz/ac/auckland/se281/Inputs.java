package nz.ac.auckland.se281;

public enum Inputs {
  ZERO,
  ONE,
  TWO,
  THREE,
  FOUR,
  FIVE;

  public static Boolean checkErrors(String input) {
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
}
