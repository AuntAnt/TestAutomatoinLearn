package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.NegativeResponse;
import pojos.PossibleTriangle;
import queryparameters.QueryParameters;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Rest {

    protected RequestSpecification setBaseUrlAndPath() {
        return given()
                .baseUri(Endpoints.POSSIBLE_TRIANGLE.getEndpoint())
                .basePath(Path.POSSIBLE_TRIANGLE.getPath())
                .contentType(ContentType.JSON)
                .log().all();
    }

    public Response getResponse(Object... parameters) {
        return setQueryParameters(parameters)
                .when().get()
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    //попробовать улучшить реализацию с мапой
    protected RequestSpecification setQueryParameters(Object... parameters) {
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

    public PossibleTriangle getPossibleTrianglePositive(Object... params) {
        return getResponse(params)
                .as(PossibleTriangle.class);
    }

    public NegativeResponse getPossibleTriangleNegative(Object... params) {
        return getResponse(params)
                .as(NegativeResponse.class);
    }
}
