package no.ntnu.idatg2001.calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.Callable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcEngineTest {

  private CalcEngine calcEngine;

  @BeforeEach
  void setUp() {
    calcEngine = new CalcEngine();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void clear() {
    calcEngine.clear();
    assertEquals(0, calcEngine.getDisplayValue());
  }
  
  @Test
  void testAddDigit() {
    calcEngine.numberPressed(5);
    assertEquals(5, calcEngine.getDisplayValue());
  }
  
  @Test
  void testAddMultipleDigits() {
    calcEngine.numberPressed(5);
    calcEngine.numberPressed(4);
    calcEngine.numberPressed(3);
    assertEquals(543, calcEngine.getDisplayValue());
  }

  @Test
  void testClear() {
    calcEngine.numberPressed(5);
    calcEngine.numberPressed(5);
    calcEngine.numberPressed(5);
    calcEngine.clear();
    assertEquals(0, calcEngine.getDisplayValue());
  }

  @Test
  void testPlus() {
    calcEngine.numberPressed(5);
    calcEngine.numberPressed(5);
    calcEngine.numberPressed(5);
    calcEngine.plus();
    assertEquals(555, calcEngine.getDisplayValue());
    calcEngine.numberPressed(3);
    assertEquals(3, calcEngine.getDisplayValue());
    calcEngine.equals();
    assertEquals(558, calcEngine.getDisplayValue());
  }
}