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

  public void play() {
    // if statement checks if there is an active game
    if (playerName != null) {
      this.roundCount++;
      Integer botFingers = botAI.botOutput(roundCount, evenCount, oddsCount, playerChoice);
      MessageCli.START_ROUND.printMessage(Integer.toString(roundCount));
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      // checks if user doesn't input a correct value and keeps asking user until they input a
      // correct
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
        winCount++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(sum), Inputs.oddsWinner(sum), "HAL-9000");
      }
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  // adds function to end game
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

  // adds function to show stats of current game
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
