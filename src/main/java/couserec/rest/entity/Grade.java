package couserec.rest.entity;

public enum Grade {
    A(4.00),
    B_PLUS(3.50),
    B(3.00),
    C_PLUS(2.50),
    C(2.00),
    D_PLUS(1.50),
    D(1.00),
    F(0.00);

    private final double value;

    Grade(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
    }
