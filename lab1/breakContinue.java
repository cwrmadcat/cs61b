public class breakContinue {
    public static void windowPosSum(int[] a, int n) {
        for (int x = 0; x < a.length; x++) {
            if (a[x] < 0) {
                continue;
            }
            int sum = 0;
            for (int y = x; y <= x + n; y++) {
                if (y == a.length) {
                    break;
                }
                sum = sum + a[y];
                a[x] = sum;
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1, -1, -1, 10, 5, -1};
        int n = 3;
        windowPosSum(a, n);
        System.out.println(java.util.Arrays.toString(a));
    }
}