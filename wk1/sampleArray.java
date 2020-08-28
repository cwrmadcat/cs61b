public class sampleArray {
    public static int max(int[] m) {
        int counter = 0;
        int value = 0;
        if (m.length == 0) {
            return value;
        }
        else {
            while (counter < m.length) {
                if (m[counter] > value) {
                    value = m[counter];
                }
                counter++;
            }
        }
        return value;
    }
    public static void main(String[] args) {
        int[] numbers = {22, 2, 15, 2, 6, 10, 21};
        System.out.println(max(numbers));
    }
}