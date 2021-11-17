package queryparameters;

public enum QueryParameters {
    TRIANGLE_SIDE_A("a"),
    TRIANGLE_SIDE_B("b"),
    TRIANGLE_SIDE_C("c"),
    TRIANGLE_SIDE_D("d");

    private final String parameter;

    QueryParameters(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }

    @Override
    public String toString() {
        return this.getParameter();
    }
}
