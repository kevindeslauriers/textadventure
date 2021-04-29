package zork;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
  private CommandWords commands; // holds all valid command words

  public Parser() {
    commands = new CommandWords();
  }

  public Command getCommand() throws java.io.IOException {
    String inputLine = "";
    String[] words;

    System.out.print("> "); // print prompt

    Scanner in = new Scanner(System.in);
    inputLine = in.nextLine();

    words = inputLine.split(" ");

    String word1 = words[0];
    String word2 = null;
    if (words.length > 1)
      word2 = words[1];

    if (commands.isCommand(word1))
      return new Command(word1, word2);
    else
      return new Command(null, word2);
  }

  /**
   * Print out a list of valid command words.
   */
  public void showCommands() {
    commands.showAll();
  }
}