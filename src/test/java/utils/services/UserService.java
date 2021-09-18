package utils.services;

import io.restassured.http.Cookies;
import rest.user.UserRequest;
import rest.user.CreateUserResponse;
import rest.user.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends RestService{
    @Override
    protected String getBasePath() {
        return "/users";
    }

    public UserService(Cookies cookies) {
        super(cookies);
    }

    public CreateUserResponse createUser(UserRequest createUser) {
        return given().spec(REQ_SPEC).body(createUser).post().as(CreateUserResponse.class);
    }

    public List<User> getUsers() {
        return given().spec(REQ_SPEC)
                .get()
                .jsonPath().getList("data", User.class);
    }
}
