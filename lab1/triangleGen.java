public class triangleGen {
    public static void triangleDraw(int n) {
        int SIZE = n;
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
    public static void main(String[] args) {
        triangleDraw(10);
    }
}