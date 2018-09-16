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

    StdDraw.setScale(-radius, radius);
    StdDraw.clear();
    StdDraw.picture(0, 0, "images/starfield.jpg");

    for (Planet p : planets) {
      p.draw();
    }

    StdDraw.show();
  }
}
