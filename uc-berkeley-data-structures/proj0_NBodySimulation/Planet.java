class Planet {
  public double xxPos;  // current x position
  public double yyPos;  // current y position
  public double xxVel;  // current velocity in x direction
  public double yyVel;  // current velocity in y direction
  public double mass;   // mass

  public String imgFileName;  // filename corresponding to
                              // image for that planet

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
}
