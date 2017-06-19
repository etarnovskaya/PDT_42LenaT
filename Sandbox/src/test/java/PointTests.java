import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Lena on 18/06/2017.
 */
public class PointTests {
  @Test
  public void testDistance()
  {
    Point p1 = new Point(1,2);
    Point p2 = new Point(7,8);
    Assert.assertEquals(p1.distance(p2), 8.48528137423857);
  }
}
