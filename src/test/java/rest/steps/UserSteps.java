package rest.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import rest.user.UserRequest;
import rest.user.CreateUserResponse;
import rest.user.User;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Класс с бизнесс логикой
 */
public class UserSteps {
    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();

    private CreateUserResponse user;

    public CreateUserResponse createUser(UserRequest createUser) {
        user = given().spec(REQ_SPEC).body(createUser).post().as(CreateUserResponse.class);
        return user;
    }

    public User getUser() {
        return given().spec(REQ_SPEC).get("/" + user.getId()).as(User.class);
    }

    public static List<User> getUsers() {
        return given().spec(REQ_SPEC)
                .get()
                .jsonPath().getList("data", User.class);
    }

    public static User getUser(int id) {
        return given().spec(REQ_SPEC).get("/" + id).as(User.class);
    }

}
