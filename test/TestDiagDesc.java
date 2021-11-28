import static org.junit.Assert.*;

import org.junit.Test;

public class TestDiagDesc {

  @Test
  public void testaGagneDiagDescNormal() {
    int[][] t = {
      { 1, 0, 0, 0, 0, 0, 0 },
      { 0, 1, 0, 0, 0, 0, 0 },
      { 0, 0, 1, 0, 0, 0, 0 },
      { 0, 0, 0, 1, 0, 0, 0 },
    };
    boolean res = AppTest.aGagneDiagDescTest(t, 0, 0, 1);
    assertTrue(res);
  }

  @Test
  public void testaGagneDiagDescFalse() {
    int[][] t = {
      { 1, 0, 0, 0, 0, 0, 0 },
      { 0, 1, 0, 0, 0, 0, 0 },
      { 0, 0, 1, 0, 0, 0, 0 },
      { 0, 0, 0, 2, 0, 0, 0 },
    };
    boolean res = AppTest.aGagneDiagDescTest(t, 3, 0, 1);
    assertFalse(res);
  }

  @Test
  public void testaGagneDiagDescAffrontement() {
    int[][] t = {
      { 1, 0, 0, 0, 0, 0, 0 },
      { 0, 1, 0, 0, 0, 0, 0 },
      { 0, 0, 1, 0, 0, 0, 0 },
      { 0, 0, 0, 1, 0, 0, 0 },
      { 0, 0, 0, 0, 1, 0, 0 },
    };
    boolean res = AppTest.aGagneDiagDescTest(t, 0, 0, 1);
    assertTrue(res);
  }
}
