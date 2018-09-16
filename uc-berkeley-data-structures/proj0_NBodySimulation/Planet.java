class Planet {
  public double xxPos;  // current x position
  public double yyPos;  // current y position
  public double xxVel;  // current velocity in x direction
  public double yyVel;  // current velocity in y direction
  public double mass;   // mass

  public String imgFileName;  // filename corresponding to
                              // image for that planet

  public static final double G = 6.67 * 1.0e-11;  // gravitational
                                                  // constant

  public Planet(double xP, double yP, double xV,
                double yV, double m, String img) {
    xxPos = xP; // equivalently, set `this.xxPos`
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  }

  public Planet(Planet p) {
    xxPos = p.xxPos;
    yyPos = p.yyPos;
    xxVel = p.xxVel;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = p.imgFileName;
  }

  public double calcDistance(Planet p) {
    // should return a double equal to the distance between the supplied planet and the planet that is doing the calculation
    // (r^2)^(1/2) = (dx^2 + dy^2)^(1/2) = r = distance
    // dx = this.xxPos - p.xxPos
    // dy = this.yyPos - p.yyPos
    double dx = this.xxPos - p.xxPos;
    double dy = this.yyPos - p.yyPos;
    return Math.sqrt(dx*dx + dy*dy);
  }

  public double calcForceExertedBy(Planet p) {
    // returns a double describing the force exerted on this planet by the given planet.
    double r = this.calcDistance(p);  // dist btwn planets
    return (G * this.mass * p.mass) / (r * r);
  }
}
