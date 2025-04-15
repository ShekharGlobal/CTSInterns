package com.cts.checkstyle;

/**
 * A simple class to demonstrate proper Checkstyle compliance.
 */
public class HelloCorrectCheckstyle {

  /**
   * The message to be printed.
   */
  private String msg;

  /**
   * Constructs a HelloCheckstyle instance with the specified message.
   *
   * @param msg the message to set
   */
  public HelloCorrectCheckstyle(String msg) {
    this.msg = msg;
  }

  /**
   * Prints the message if it's not empty.
   */
  public void print() {
    if (!msg.equals("")) {
      System.out.println("Msg: " + msg);
    }
  }

  /**
   * The main method to execute the example.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    HelloCorrectCheckstyle h = new HelloCorrectCheckstyle("Good Style!");
    h.print();
  }
}
