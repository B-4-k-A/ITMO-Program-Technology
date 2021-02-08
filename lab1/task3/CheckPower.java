import java.util.Date;

public class CheckPower {
    public static void main(String[] args) {
        long begin = new Date().getTime();
        int i = 0;
        // long i = 0;
        while(i != 100000000) {
            i++;
        }
        long end = new Date().getTime();
        System.out.println(end - begin);
    }
    
}
