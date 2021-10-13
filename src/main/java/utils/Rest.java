package utils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojos.NegativeResponse;
import pojos.PossibleTriangle;
import queryparameters.QueryParameters;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class Rest {
    public RequestSpecification possibleTriangle() {
        return given()
                .baseUri(Endpoints.POSSIBLE_TRIANGLE.getEndpoint())
                .basePath(Path.POSSIBLE_TRIANGLE.getPath())
                .contentType(ContentType.JSON);
    }

    public RequestSpecification setQueryParameters(int parameterA, int parameterB, int parameterC){
        return possibleTriangle()
                .queryParam(QueryParameters.TRIANGLE_SIDE_A.getParameter(), parameterA)
                .queryParam(QueryParameters.TRIANGLE_SIDE_B.getParameter(), parameterB)
                .queryParam(QueryParameters.TRIANGLE_SIDE_C.getParameter(), parameterC);
    }

    public PossibleTriangle getPossibleTriangleWithoutParameters() {
        return possibleTriangle()
                .when().get()
                .then().statusCode(StatusCodes.OK.getValue())
                .extract()
                .as(PossibleTriangle.class);
    }

    public PossibleTriangle getPossibleTriangleWithValidParameters(int parameterA, int parameterB, int parameterC) {
        return setQueryParameters(parameterA, parameterB, parameterC)
                .when().get()
                .then().statusCode(StatusCodes.OK.getValue())
                .extract()
                .as(PossibleTriangle.class);
    }

    public NegativeResponse getPossibleTriangleWithInvalidParameters(int parameterA, int parameterB, int parameterC) {
        return setQueryParameters(parameterA, parameterB, parameterC)
                .when().get()
                .then().statusCode(StatusCodes.BAD_REQUEST.getValue())
                .extract()
                .as(NegativeResponse.class);
    }

    public NegativeResponse getPossibleTriangleWithFractionalParameters(
            float parameterA, float parameterB, float parameterC) {
        return possibleTriangle()
                .queryParam(QueryParameters.TRIANGLE_SIDE_A.getParameter(), parameterA)
                .queryParam(QueryParameters.TRIANGLE_SIDE_B.getParameter(), parameterB)
                .queryParam(QueryParameters.TRIANGLE_SIDE_C.getParameter(), parameterC)
                .when().get()
                .then().statusCode(StatusCodes.BAD_REQUEST.getValue())
                .extract()
                .as(NegativeResponse.class);
    }
}
