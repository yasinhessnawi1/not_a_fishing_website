package no.ntnu.idatg2001.calculator;

/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 *
 * @version 2016.02.29
 * @author: Michael Kölling and David J. Barnes
 */
public class Calculator {
  private CalcEngine engine;
  private UserInterface gui;

  /**
   * Create a new calculator and show it.
   */
  public Calculator() {
    engine = new CalcEngine();
    gui = new UserInterface(engine);
  }

  /**
   * In case the window was closed, show it again.
   */
  public void show() {
    gui.setVisible(true);
  }

  /**
   * Start the calculator GUI.
   *
   * @param args Command line parameters (not used)
   */
  public static void main(String[] args) {
    new Calculator();
  }
}
