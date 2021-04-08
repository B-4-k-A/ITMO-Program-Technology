package WorkArray;

public class U0901WorkArray<T extends Number> {
    T[] arrNums;

    public U0901WorkArray(T[] numP) {
        this.arrNums = numP;
    }

    public double sum() {
        double doubleWork = 0;
        for(int i = 0; i < arrNums.length; i++) {
            doubleWork += arrNums[i].doubleValue();
        }
        return doubleWork;
    }
}
