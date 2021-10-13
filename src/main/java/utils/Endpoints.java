package utils;

/**
 * Перечисление для хранения эндпойнтов
 */
public enum Endpoints {
    POSSIBLE_TRIANGLE("https://possible-triangle.herokuapp.com/");

    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
