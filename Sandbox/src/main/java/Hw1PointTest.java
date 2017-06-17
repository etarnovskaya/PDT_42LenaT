/**
 * Created by Lena on 18/06/2017.
 */
public class Hw1PointTest {
  public static void main(String[] args) {

    Point p = new Point(1, 2, 8, 9);
    // Point p2 = new Point(7, 8);

    System.out.println("Distance between two points"+" "+p.x1 +", "+p.y1+ " and "+p.x2 +", "+p.y2+" =" + " "+ p.distance());
  }
}
