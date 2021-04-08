package ru.billing.stocklist;

public class TechnicalItem extends GenericItem{

    private short warrantyTime;

    public TechnicalItem(String name, float price, short warrantTime) {
        super(name, price);
        this.warrantyTime = warrantTime;
    }

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TechnicalItem that = (TechnicalItem) o;

        return warrantyTime == that.warrantyTime;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) warrantyTime;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TechnicalItem temp = (TechnicalItem) super.clone();
        temp.setWarrantyTime(warrantyTime);
        return temp;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("\t%d", warrantyTime);
    }
}
