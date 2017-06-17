/**
 * Created by Lena on 18/06/2017.
 */
public class Point {
  public double y1;
  public double x1;
  public double y2;
  public double x2;

  public Point(double x1, double y1, double x2, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;

  }

  public static double power(double number, int power) {
    double res;
    res = 0;
    for (int i = 1; i <= power; i++)
      res = number * number;
    return res;
  }

  public double distance() {
//Point p1, Point p2
//    AC = xb - xa;
//    BC = yb - ya.
//    Воспользовавшись теоремой Пифагора, вычислим длину отрезка AB:
//    AB = √AC2 + BC2.
    return Math.sqrt(power((this.x2 - this.x1), 2) + power((this.y2 - this.y1), 2));

  }

}
