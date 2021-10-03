import endpoints.Endpoints;
import endpoints.Path;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojos.PossibleTriangle;
import queryparameters.QueryParameters;

import static io.restassured.RestAssured.given;

public class Rest {
    public RequestSpecification possibleTriangle() {
        return given()
                .baseUri(Endpoints.POSSIBLE_TRIANGLE.getEndpoint())
                .basePath(Path.POSSIBLE_TRIANGLE.getPath())
                .contentType(ContentType.JSON);
    }

    public PossibleTriangle getPossibleTriangleWithoutParameters() {
        return possibleTriangle()
                .when().get()
                .then().statusCode(200)
                .extract()
                .as(PossibleTriangle.class);
    }

    public PossibleTriangle getPossibleTriangleWithParameters(int parameterA, int parameterB, int parameterC) {
        return possibleTriangle()
                .queryParam(QueryParameters.TRIANGLE_SIDE_A.getParameter(), parameterA)
                .queryParam(QueryParameters.TRIANGLE_SIDE_B.getParameter(), parameterB)
                .queryParam(QueryParameters.TRIANGLE_SIDE_C.getParameter(), parameterC)
                .when().get()
                .then().statusCode(200)
                .extract()
                .as(PossibleTriangle.class);
    }
}
