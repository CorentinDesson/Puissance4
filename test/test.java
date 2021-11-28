import static org.junit.Assert.*;

import org.junit.Test;

public class test {

  @Test
  public void testaGagneHor() {
    int[][] t = { { 1, 1, 1, 1, 0, 0, 0 } };
    boolean res = AppTest.aGagneHorTest(0, 0, 1, t);
    assertTrue(res);
  }
}
