package endpoints;

public enum Path {
    POSSIBLE_TRIANGLE("triangle/possible");

    private final String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
