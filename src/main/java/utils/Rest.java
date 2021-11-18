package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import queryparameters.QueryParameters;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Класс отправки запроса на проверку треугольника
 */
public class Rest {

    protected RequestSpecification setBaseUrlAndPath() {
        return given()
                .baseUri(Endpoints.POSSIBLE_TRIANGLE.getEndpoint())
                .basePath(Path.POSSIBLE_TRIANGLE.getPath())
                .contentType(ContentType.JSON)
                .log().all();
    }

    @SafeVarargs
    public final <T> Response getResponse(T... parameters) {
        return setQueryParameters(parameters)
                .when().get()
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    @SafeVarargs
    protected final <T> RequestSpecification setQueryParameters(T... parameters) {
        List<Object> params = Arrays.asList(parameters);
        QueryParameters[] queryParameters = QueryParameters.values();
        Map<String, Object> paramsValues = new HashMap<>();

        if (params.size() > 4) {
            throw new IndexOutOfBoundsException("Too many parameters");
        }

        for (int i = 0; i < params.size(); i++) {
            paramsValues.put(queryParameters[i].toString(), params.get(i));
        }

        return setBaseUrlAndPath()
                .queryParams(paramsValues);
    }
}
