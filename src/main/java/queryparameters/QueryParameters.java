package queryparameters;

public enum QueryParameters {
    TRIANGLE_SIDE_A("a"),
    TRIANGLE_SIDE_B("b"),
    TRIANGLE_SIDE_C("c");

    private final String parameter;

    QueryParameters(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
