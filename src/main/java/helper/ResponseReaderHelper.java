package helper;

import pojos.NegativeResponse;
import pojos.PossibleTriangle;
import utils.Rest;
import utils.StatusCodes;

/**
 * Вспомогательный класс
 */
public class ResponseReaderHelper {

    private final Rest rest = new Rest();

    public PossibleTriangle readResponseWithValidParametersAsObject(Integer... params) {
        return rest.getResponse(params)
                .then()
                .statusCode(StatusCodes.OK.getValue())
                .extract()
                .as(PossibleTriangle.class);
    }

    public NegativeResponse readResponseWithInvalidParametersAsObject(Object... params) {
        return  rest.getResponse(params)
                .then().statusCode(StatusCodes.BAD_REQUEST.getValue())
                .extract()
                .as(NegativeResponse.class);
    }
}
