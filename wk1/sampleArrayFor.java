public class sampleArrayFor {
    public static int max(int[] m) {
        int value = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] > value) {
                value = m[i];
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{22, 2, 15, 2, 6, 10, 21};
        System.out.println(max(numbers));
    }
}