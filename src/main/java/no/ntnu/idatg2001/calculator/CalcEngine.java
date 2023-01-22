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
  private int oldValue;
  private boolean newValue;
  boolean pointPressed;
  private char operation; // added variable to keep track of operation

  /**
   * Create a CalcEngine.
   */
  public CalcEngine() {
    newValue = true;
    pointPressed = false;
  }

  /**
   * Get the display value.
   *
   * @return The value that should currently be displayed
   *     on the calculator display.
   */
  public int getDisplayValue() {
    return  displayValue;
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
    if ( storedValue != 0 )
    {
      if ( oldValue == 0 )
      {
        oldValue = oldValue + storedValue + displayValue;
      } else
      {
        oldValue = oldValue + displayValue;
      }

    }
    storedValue = displayValue;
    operation = '+';
    newValue = true;
  }

  /**

   The 'minus' button was pressed.
   */
  public void minus() {
    if ( storedValue != 0 )
    {
      if ( oldValue == 0 )
      {
        oldValue = storedValue - displayValue - oldValue;
      } else
      {
        oldValue = oldValue - displayValue;
      }

    }
    storedValue = displayValue;
    operation = '-';
    newValue = true;

  }

  public void multiply() {
    if (storedValue == 0) {
      storedValue = displayValue;
    } else
    {
      if (storedValue != 0){
        storedValue = storedValue * displayValue;
      }

    }
    operation = 'x';
    newValue = true;
  }
  public void divide() {
    if (storedValue == 0) {
      storedValue = displayValue;
    } else
    {
      if (storedValue != 0){
        storedValue = storedValue / displayValue;
      }

    }
    operation = '/';
    newValue = true;
  }
  /**
   * The '=' button was pressed.
   *
   * @return
   */
  public double equals()
  {

    if ( operation == '+')
    {
      plusOperation ( );
    } else if ( operation == '-')
    {
      minusOperation ( );
    } else if ( operation == 'x')
    {
      multiplyOperation ( );
    } else if (operation == '/') {
      divideOperation();
    } else if (operation == '?') {
      info();
    } else if (operation == '√')
    {
      squareRoot();
    } else if (operation == '.') {
      decimal();
    }

    storedValue = oldValue = 0;
      newValue = true;
      return displayValue;
    }

  private void multiplyOperation ( )
  {
      displayValue = displayValue * storedValue;
  }
  private void divideOperation ( )
  {
      displayValue = storedValue / displayValue;
  }

  private void minusOperation ( )
  {
    if ( oldValue != 0 )
    {
      displayValue = oldValue - displayValue;
    } else
    {
      displayValue -= storedValue;
    }
  }

  private void plusOperation ( )
  {
    if ( oldValue != 0 )
  {
    displayValue += oldValue;
  } else
  {
    displayValue += storedValue;
  }
  }

  public String info()
  {
    operation = '?';
    return getTitle() + getAuthor() + getVersion();
  }
public void squareRoot()
  {
    displayValue = (int) Math.sqrt(displayValue);
    operation = '√';
    newValue = true;
  }
  //needs fixing
  public void decimal() {
    storedValue = displayValue;
    String firstNumber = String.valueOf(storedValue);
    String secondNumber  = String.valueOf(displayValue);
    displayValue = Integer.parseInt(firstNumber + "." + secondNumber);
  }


    /**
     * The 'C' (clear) button was pressed.
     */
  public void clear() {
    displayValue = 0;
    storedValue = 0;
    pointPressed = false;
  }

  /**
   * Get the title of the calculation engine.
   *
   * @return The title of this calculation engine.
   */
  public String getTitle() {
    return " Calculator";
  }

  /**
   * Get the author of the calculation engine.
   *
   * @return The author of this engine. This string is displayed as it is,
   *     so it should say something like "Written by H. Simpson".
   */
  public String getAuthor() {
    return "Yasin_Hessnawi";
  }

  /**
   * Get the version of the calculation engine.
   *
   * @return The version number of this engine. This string is displayed as
   *     it is, so it should say something like "Version 1.1".
   */
  public String getVersion() {
    return "1.0.0";
  }

}
