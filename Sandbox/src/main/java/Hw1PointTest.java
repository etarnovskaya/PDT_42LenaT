/**
 * Created by Lena on 18/06/2017.
 */
public class Hw1PointTest {
  public static void main(String[] args) {

    Point p1 = new Point(0, 0);

    Point p2 = new Point(-1, -7);

    System.out.println("Distance between two points" + " " + p1.x + ", " + p1.y + " and " + p2.x + ", " + p2.y + " =" + " " + p1.distance(p2));
  }
}
