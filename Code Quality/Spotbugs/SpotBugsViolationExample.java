package com.cts.spot;

/**
 * This class contains intentional SpotBugs violations for demo purposes.
 */
public class SpotBugsViolationExample {

  private String name;
  private int[] numbers;

  public SpotBugsViolationExample(String name) {
    this.name = name;
  }

  public void printLength() {
    // Potential NPE (Null Pointer Exception)
    System.out.println("Name length: " + name.length());
  }

  public void divideByZero() {
    int x = 10;
    int y = 0;
    int result = x / y; // Division by zero (runtime crash)
    System.out.println("Result: " + result);
  }

  public void emptySynchronizedBlock() {
    synchronized (this) {
      // Empty synchronized block — meaningless and suspicious
    }
  }

  public void createDeadStore() {
    int x = 100;
    x = 200; // Dead store: value 100 is overwritten before being used
    System.out.println("X: " + x);
  }

  public void exposeInternalArray() {
    // Security: exposes internal representation
    numbers = new int[] {1, 2, 3};
    int[] external = getNumbers();
    external[0] = 99; // External code can now modify internal array
  }

  public int[] getNumbers() {
    return numbers;
  }

  public static void main(String[] args) {
    SpotBugsViolationExample demo = new SpotBugsViolationExample(null); // Will trigger NPE
    demo.printLength();
    demo.divideByZero();
    demo.emptySynchronizedBlock();
    demo.createDeadStore();
    demo.exposeInternalArray();
  }
}
