public class triangle {
    public static void main(String[] args) {
        int SIZE = 5;
        int row = 0;
        while (row < SIZE) {
            int col = 0;
            while (col <= row) {
                System.out.print('*');
                col++;
            }
            System.out.println();
            row++;
        }
    }
}