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

  public double calcForceExertedByX(Planet p) {
    // returns a double describing the force exerted on this planet by the given planet, in the x direction only.
    // Fx = (F * dx) / r
    double F = this.calcForceExertedBy(p);
    double dx = this.xxPos - p.xxPos;
    double r = this.calcDistance(p);
    return -((F * dx) / r);
  }

  public double calcForceExertedByY(Planet p) {
    // returns a double describing the force exerted on this planet by the given planet, in the y direction only.
    double F = this.calcForceExertedBy(p);
    double dy = this.yyPos - p.yyPos;
    double r = this.calcDistance(p);
    return -((F * dy) / r);
  }

  public double calcNetForceExertedByX(Planet[] allPlanets) {
    double net = 0.0;
    for (Planet p : allPlanets) {
      if (!this.equals(p)) {
        net += this.calcForceExertedByX(p);
      }
    }
    return net;
  }

  public double calcNetForceExertedByY(Planet[] allPlanets) {
    double net = 0.0;
    for (Planet p : allPlanets) {
      if (!this.equals(p)) {
        net += this.calcForceExertedByY(p);
      }
    }
    return net;
  }

  public void update(double dt, double fX, double fY) {
    // determines how much the forces exerted on the planet will cause that planet to accelerate, and the resulting change in the planet’s velocity and position in a small period of time dt.
    double xAccel = fX / mass;
    double yAccel = fY / mass;

    xxVel += dt * xAccel;
    yyVel += dt * yAccel;

    xxPos += dt * xxVel;
    yyPos += dt * yyVel;
  }

  public void draw() {
    StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
  }
}
