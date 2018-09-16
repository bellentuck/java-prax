class NBody {
  public static double readRadius(String filename) {
    // return the second line in the file.
    In in = new In(filename);
    in.readInt();
    return in.readDouble();
  }
}
