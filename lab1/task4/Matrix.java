public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                matrix[i][j] = (int)Math.round(Math.random() * 10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        } 

        System.out.println();
        for(int i = 0; i < 3; i++) {
            for(int j = i + 1; j < 3; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        } 
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        } 


    }

    private static Integer clone(int i) {
        return i;
    }
    
}
