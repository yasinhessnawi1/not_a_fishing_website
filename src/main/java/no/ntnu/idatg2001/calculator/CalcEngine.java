package no.ntnu.idatg2001.calculator;

/**
 * The main part of the calculator doing the calculations.
 *
 * @version 0.1 (incomplete)
 * @author: (none yet)
 */
public class CalcEngine {
  // Put instance variables here.
  private int displayValue;
  private int storedValue;
  private boolean newValue;

  /**
   * Create a CalcEngine.
   */
  public CalcEngine() {
    newValue = true;
  }

  /**
   * Get the display value.
   *
   * @return The value that should currently be displayed
   *     on the calculator display.
   */
  public int getDisplayValue() {
    return displayValue;
  }

  /**
   * A number button was pressed.
   * Either start a new operand, or incorporate this number as
   * the least significant digit of an existing one.
   *
   * @param number The number pressed on the calculator.
   */
  public void numberPressed(int number) {
    if (newValue) {
      displayValue = number;
      newValue = false;
    }
    else {
      displayValue = 10 * displayValue + number;
    }
  }

  /**
   * The 'plus' button was pressed.
   */
  public void plus() {
    storedValue = displayValue;
    newValue = true;
  }

  /**
   * The 'minus' button was pressed.
   */
  public void minus() {
    storedValue = displayValue;
    newValue = true;

  }

  /**
   * The '=' button was pressed.
   */
  public int equals() {


    if (){
      displayValue += storedValue;
      return displayValue;

    } else if (minus())
    {
      displayValue -= storedValue;
      return displayValue;
    }
    return displayValue;
  }

  /**
   * The 'C' (clear) button was pressed.
   */
  public void clear() {
    displayValue = 0;
    storedValue = 0;
  }

  /**
   * Get the title of the calculation engine.
   *
   * @return The title of this calculation engine.
   */
  public String getTitle() {
    return "";
  }

  /**
   * Get the author of the calculation engine.
   *
   * @return The author of this engine. This string is displayed as it is,
   *     so it should say something like "Written by H. Simpson".
   */
  public String getAuthor() {
    return "";
  }

  /**
   * Get the version of the calculation engine.
   *
   * @return The version number of this engine. This string is displayed as
   *     it is, so it should say something like "Version 1.1".
   */
  public String getVersion() {
    return "";
  }
}
