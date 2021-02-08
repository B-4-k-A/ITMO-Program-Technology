import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        boolean v_boolean = true;
        byte v_byte = Byte.MAX_VALUE;
        short v_short = Short.MAX_VALUE;
        char v_char = 'a';
        int v_int = Integer.MAX_VALUE;
        long v_long = Long.MAX_VALUE;
        float v_float = Float.MAX_VALUE;
        double v_double = Double.MAX_VALUE;

        List<Object> list = new ArrayList<>();
        list.add(v_boolean);
        list.add(v_byte);
        list.add(v_short);
        list.add(v_char);
        list.add(v_int);
        list.add(v_long);
        list.add(v_float);
        list.add(v_double);
        list.stream().forEach(o -> System.out.println("This is a " + o.getClass() + ": " + o));
        v_byte = 120;
        v_short = 129;
        v_char = 'a';
        v_int = 65999;
        v_long = 42949967296l; /* Wrong ! */
        v_float = 0.33333334f; /* Wrong ! */
        v_double = 0.333333333333333;
        // v_double = true; /* Wrong! */
        v_boolean = true;
    }
}
