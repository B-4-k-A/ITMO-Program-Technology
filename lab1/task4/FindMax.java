public class FindMax {
    
    public static void main(String[] args) {
        int[] mas = {12,43,12,-65,778,123,32,76};
        int max = mas[0];
        for(int i : mas) {
            if(max < i) {
                max = i;
            }
        }
        System.out.println(max);
    }

}
