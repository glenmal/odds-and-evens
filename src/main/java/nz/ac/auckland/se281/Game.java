package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private Integer roundCount = 0;
  private String playerName = null;
  private AI botAI;
  private Choice playerChoice;
  private Integer oddsCount;
  private Integer evenCount;
  private Integer winCount;

  /**
   * Starts a new game of "Odds and Evens" with initial parameters set to user inputs, and game
   * stats are zeroed (win, odd, even and round counts)
   *
   * @param difficulty sets the difficulty of the AI bot to the user input (EASY, MEDIUM, HARD)
   * @param choice sets the user's winning condition (ODD or EVEN)
   * @param options gets the player's name
   */
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
    winCount = 0;
  }

  /**
   * Lets the user play one round of the odds and evens game by taking an integer input from the
   * user (0 - 5) and generates an answer from the AI which uses a strategy depending on the
   * difficulty selected prior. Also calculates the sum and increments game stats when required
   * (win, odd, even and round counts)
   *
   * <p>If there is no game active, it prints an error message
   */
  public void play() {
    // if statement checks if there is an active game
    if (playerName != null) {
      this.roundCount++;
      Integer botFingers = botAI.botOutput(roundCount, evenCount, oddsCount, playerChoice);
      MessageCli.START_ROUND.printMessage(Integer.toString(roundCount));
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      // checks if user doesn't input a correct value and keeps asking user until they input a
      // correct value
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
        winCount++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(sum), Inputs.oddsWinner(sum), "HAL-9000");
      }
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  /**
   * Function that allows the user to end a current active game, by zeroing all game stats and
   * setting all game parameters (botAI, player choice, player name) to null. Prints the game stats
   * and who won or if there was a tie, it declares a tie.
   *
   * <p>If there is no game active, it prints an error message
   */
  public void endGame() {
    // if statement checks if there is an active game
    if (playerName != null) {
      Integer botWins = this.roundCount - this.winCount;
      showStats();
      if (winCount == botWins) {
        MessageCli.PRINT_END_GAME_TIE.printMessage();
      } else if (botWins > winCount) {
        MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
      } else {
        MessageCli.PRINT_END_GAME.printMessage(playerName);
      }
      // resets game conditions
      this.botAI = null;
      this.playerChoice = null;
      this.playerName = null;
      roundCount = 0;
      oddsCount = 0;
      evenCount = 0;
      winCount = 0;
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  /**
   * Function that shows the current active game stats (bot wins, user wins, rounds played in the
   * active game )
   *
   * <p>If there is no game active, it prints an error message
   */
  public void showStats() {
    // if statement checks if there is an active game
    if (playerName != null) {
      Integer botWins = this.roundCount - this.winCount;
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName, Integer.toString(winCount), Integer.toString(roundCount - winCount));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "HAL-9000", Integer.toString(botWins), Integer.toString(roundCount - botWins));
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }
}
