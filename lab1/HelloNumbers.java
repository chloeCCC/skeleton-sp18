public class HelloNumbers {
    public static int larger(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }

    public static void main(String[] args) {
        larger(5, 6);
        int x = 0;
        while (x < 10) {
            System.out.println(x);
            x = x+1;
        }
//        x = "horse";
    }


}
 /* Java variable:
 1. Must be declared first.
 2. Must be a specific type.
 3. Type can't be changed
 4. Types are verifies before the code even runs.
  */

/* Java function (method):
1. Function must be declared as part of the class of JAVA.
2. To declare function: "public static"
3. All parameters/return value of func must have declared types.
 */
