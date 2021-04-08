package WorkArray;

import java.math.BigDecimal;

public class U0901Main {
    public static void main(String[] args) {
        Integer[] intArr = {5, 3, 2, 3, 7};
        Float[] floatArr = {0.5f, 0.3f, 0.2f, 1.3f, 0.7f};
        U0901WorkArray<Integer> insWorkArrayInt = new U0901WorkArray<>(intArr);
        U0901WorkArray<Float> insWorkArrayFloat = new U0901WorkArray<>(floatArr);
        System.out.println(insWorkArrayInt.sum());
//        System.out.println(insWorkArrayFloat.sum());
        System.out.printf("%f%n", insWorkArrayFloat.sum());

    }
}
