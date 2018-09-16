class NBody {

  /**
  Given a file name, readRadius returns a double corresponding to the radius of the universe in that file.
  */
  public static double readRadius(String filename) {
    // return the second line in the file.
    In in = new In(filename);
    in.readInt();
    return in.readDouble();
  }

  /**
  Given a file name, readPlanets returns an array of Planets corresponding to the planets in the file.
  */
  public static Planet[] readPlanets(String filename) {
    In in = new In(filename);
    int numPlanets = in.readInt();
    Planet[] planets = new Planet[numPlanets];
    in.readDouble(); // discard radius
    for (int i = 0; i < numPlanets; i++) {
      planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
    }
    return planets;
  }

  public static void main(String[] args) {
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    double radius = NBody.readRadius(filename);
    Planet[] planets = NBody.readPlanets(filename);

    // graphics technique to prevent flickering in the animation
    StdDraw.enableDoubleBuffering();

    double time = 0.0;
    while (time < T) {
      double[] xForces = new double[planets.length];
      double[] yForces = new double[planets.length];
      for (int i = 0; i < planets.length; i++) {
        xForces[i] = planets[i].calcNetForceExertedByX(planets);
        yForces[i] = planets[i].calcNetForceExertedByY(planets);
      }

      for (int i = 0; i < planets.length; i++) {
        planets[i].update(dt, xForces[i], yForces[i]);
      }

      StdDraw.setScale(-radius, radius);
      StdDraw.clear();
      StdDraw.picture(0, 0, "images/starfield.jpg");

      for (Planet p : planets) {
        p.draw();
      }

      StdDraw.show();
      StdDraw.pause(10);

      time += dt;
    }

    // When the simulation is over, i.e. when you’ve reached time T, print out the final state of the universe in the same format as the input.
    StdOut.printf("%d\n", planets.length);
    StdOut.printf("%.2e\n", radius);
    for (Planet p : planets) {
      StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
      p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
    }
  }
}
