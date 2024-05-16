package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/**
 * OOP Requirements:
 *
 * <p>strategy design pattern for the 3 different AI's strategies (Random and Top) and change them
 * at runtime
 *
 * <p>Also you should use the Factory design pattern to create the different AI instances based on
 * the difficulty level given by the player (EASY, MEDIUM, or HARD).
 *
 * <p>For the Strategy design pattern make sure there is the method setStrategy as we did in class
 * (call the meothod exactly like this).
 *
 * <p>You should use at least 1 interface and 1 abstract class or at least 2 abstract classes or at
 * least 2 interfaces. This includes those interfaces/abstract classes that you will need to create
 * to implement the design patterns.
 */

/** This class represents the Game is the main entry point. */
public class Game {
  private Integer roundCount = 0;
  private String playerName = "";
  private AI botAI;
  private Choice playerChoice;
  private Integer oddsCount;
  private Integer evenCount;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // generates bot to play against
    this.botAI = AIFactory.generateAI(difficulty);
    this.playerChoice = choice;
    this.playerName = options[0];
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(this.playerName);
    roundCount = 0;
    oddsCount = 0;
    evenCount = 0;
  }

  public void play() {
    this.roundCount++;
    Integer botFingers = botAI.botOutput(roundCount, evenCount, oddsCount, playerChoice);
    MessageCli.START_ROUND.printMessage(Integer.toString(roundCount));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    // checks if user doesn't input a correct value and keeps asking user until they input a correct
    // value
    while (Inputs.checkFingerErrors(input)) {
      MessageCli.INVALID_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }
    MessageCli.PRINT_INFO_HAND.printMessage(this.playerName, input);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(botFingers));

    // adds to even count or odd count
    if (Integer.parseInt(input) % 2 == 0) {
      evenCount++;
    } else {
      oddsCount++;
    }

    // checks if the player won
    Integer sum = Integer.parseInt(input) + botFingers;
    if (Inputs.winCalc(Integer.parseInt(input), botFingers, this.playerChoice)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(sum), Inputs.oddsWinner(sum), playerName);
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(sum), Inputs.oddsWinner(sum), "HAL-9000");
    }
  }

  public void endGame() {}

  public void showStats() {}
}
