public class WindowSum {

  /** The goal here is to *replace* each element a[i]
     with the sum of a[i] through a[i + n], but only
     if a[i] is positive valued.

     If there are not enough values because we reach the
     end of the array, we sum only as many values as we have.


     For example, suppose we call windowPosSum with the
     array a = {1, 2, -3, 4, 5, 4}, and n = 3.

     In this case, we’d:
     (1) Replace a[0] with a[0] + a[1] + a[2] + a[3].
     (2) Replace a[1] with a[1] + a[2] + a[3] + a[4].
     (3) Not do anything to a[2] because it’s negative.
     (4) Replace a[3] with a[3] + a[4] + a[5].
     (5) Replace a[4] with a[4] + a[5].
     (6) Not do anything with a[5] because there are no
         values after a[5].

     Thus, the result after calling windowPosSum would be
     {4, 8, -3, 13, 9, 4}.


     As another example, if we called windowPosSum
     with the array a = {1, -1, -1, 10, 5, -1}, and n = 2,
     we’d get {-1, -1, -1, 14, 4, -1}.


     This exercise courtesy Josh Hug's UC Berkeley
     Data Structures course (https://sp18.datastructur.es/,
     https://sp18.datastructur.es/materials/hw/hw0/hw0).
  */


  public static void windowPosSum(int[] a, int n) {

    // init our first windowSum
    int windowSum = 0;
    for (int i = 0; i <= n && i < a.length; i++) {
      windowSum += a[i];
    }

    // iterate thru input array
    for (int j = 0; j < a.length; j++) {
      int el = a[j];
      if (el > 0) {
        a[j] = windowSum;
      }

      // each iteration, update windowSum appropriately
      windowSum -= el;
      if (j + n + 1 < a.length) {
        windowSum += a[j + n + 1];
      }
    }

  }


  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}
