package app;

public class BSO {
    private long value1;
    private long value2;

    public void setValue1(long value1) {
        this.value1 = value1;
    }

    public void setValue2(long value2) {
        this.value2 = value2;
    }

    public long getValue1() {
        return value1;
    }

    public long getValue2() {
        return value2;
    }

    @Override
    public String toString() {
        return "variable1 ="+getValue1()+"Value2="+getValue2();
    }
}
