import static org.junit.Assert.*;
import org.junit.Test;
public class TestDiagMont {
    
    @Test
    public void testaGagneDiagMontNormal() {
      int[][] t = {
        { 0, 0, 0, 1, 0, 0, 0 },
        { 0, 0, 1, 0, 0, 0, 0 },
        { 0, 1, 0, 0, 0, 0, 0 },
        { 1, 0, 0, 0, 0, 0, 0 },
      };
      boolean res = AppTest.aGagneDiagMontTest(t, 3, 0, 1);
      assertTrue(res);
    }

    @Test
    public void testaGagneDiagMontFalse() {
      int[][] t = {
        { 0, 0, 0, 2, 0, 0, 0 },
        { 0, 0, 1, 0, 0, 0, 0 },
        { 0, 1, 0, 0, 0, 0, 0 },
        { 1, 0, 0, 0, 0, 0, 0 },
      };
      boolean res = AppTest.aGagneDiagMontTest(t, 3, 0, 1);
      assertFalse(res);
    }

    @Test
    public void testaGagneDiagMontAffrontement() {
      int[][] t = {
        { 0, 0, 2, 1, 2, 0, 0 },
        { 0, 2, 1, 2, 0, 0, 0 },
        { 2, 1, 2, 0, 0, 0, 0 },
        { 1, 2, 0, 0, 0, 0, 0 },
        { 2, 0, 0, 0, 0, 0, 0 },
      };
      boolean res = AppTest.aGagneDiagMontTest(t, 3, 0, 1);
      assertTrue(res);
    }
    
}
