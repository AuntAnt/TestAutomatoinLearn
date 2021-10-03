package utils;

public enum StatusCodes {
    OK(200),
    BAD_REQUEST(400);

    private final int statusCode;

    StatusCodes(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getValue() {
        return statusCode;
    }
}
