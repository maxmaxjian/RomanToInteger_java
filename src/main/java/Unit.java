public enum Unit {
    THOUSANDS("", "", "M"),
    HUNDREDS("M", "D", "C"),
    TENS("C", "L", "X"),
    ONES("X", "V", "I");

    private final String ten;
    private final String five;
    private final String one;

    Unit(String ten, String five, String one) {
        this.ten = ten;
        this.five = five;
        this.one = one;
    }

    public String ten() {
        return ten;
    }

    public String five() {
        return five;
    }

    public String one() {
        return one;
    }
}
