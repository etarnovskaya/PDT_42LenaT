/**
 * Created by Lena on 18/06/2017.
 */
public class Point {
  public double y;
  public double x;


  public Point(double x, double y) {
    this.x = x;
    this.y = y;

  }

  public static double power(double number, int power) {
    double res;
    res = 0;
    for (int i = 1; i <= power; i++)
      res = number * number;
    return res;
  }

  public double distance(Point point) {
    return Math.sqrt(Math.pow((this.x - point.x), 2) + (Math.pow((this.y - point.y), 2)));

  }

}
