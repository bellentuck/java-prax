/**
 *  Tests pairwise force
 */
public class TestPlanet {
  public static void main(String[] args) {
    /**
    *  Tests pairwise force calculations.
    */
    checkPairwiseForce();
  }

  /**
    *  Checks whether or not two Doubles are equal and prints the result.
    *
    *  @param  expected    Expected double
    *  @param  actual      Double received
    *  @param  label       Label for the 'test' case
    *  @param  eps         Tolerance for the double comparison.
    */
  private static void checkEquals(double actual, double expected, String label, double eps) {
    if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
      System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

  /**
    *  Checks the Planet class to make sure calcForceExertedByXY works.
    */
  private static void checkCalcForceExertedByXY() {
      System.out.println("Checking calcForceExertedByX and calcForceExertedByY...");

      Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
      Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");
      Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

      checkEquals(p1.calcForceExertedByX(p2), 133.4, "calcForceExertedByX()", 0.01);
      checkEquals(p1.calcForceExertedByX(p3), 4.002e-11, "calcForceExertedByX()", 0.01);
      checkEquals(p1.calcForceExertedByY(p2), 0.0, "calcForceExertedByY()", 0.01);
      checkEquals(p1.calcForceExertedByY(p3), 5.336e-11, "calcForceExertedByY()", 0.01);
  }

  /**
   * Checks pairwise forces by making sure
   * calcForceExertedByXY works.
   */
  public static void checkPairwiseForce() {
    System.out.println("Constructing planets...");
    Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
    Planet p2 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

    System.out.println("Checking pairwise forces...");
    double p1p2X = p1.calcForceExertedByX(p2);
    double p1p2Y = p1.calcForceExertedByY(p2);
    System.out.format("Pairwise forces are (%e, %e)\n", p1p2X, p1p2Y);
    checkEquals(p1p2X, 4.002e-11, "calcForceExertedByX()", 0.01);
    checkEquals(p1p2Y, 5.336e-11, "calcForceExertedByY()", 0.01);
  }
}
