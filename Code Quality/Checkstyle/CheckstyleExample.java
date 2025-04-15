package com.cts.checkstyle;

/**
 * A class to demonstrate simple field assignment and method invocation.
 */
public class CheckstyleExample {

  /**
   * The value to be printed.
   */
  private int value;

  /**
   * Constructs a CheckstyleExample with the specified value.
   *
   * @param value the value to assign
   */
  public CheckstyleExample(int value) {
    this.value = value;
  }

  /**
   * Prints the value to the console.
   */
  public void printValue() {
    System.out.println("Value: " + value);
  }

  /**
   * The main method to run the example.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    CheckstyleExample obj = new CheckstyleExample(10); // Creating object with value 10
    obj.printValue(); // Calling method to print the value
  }
}
