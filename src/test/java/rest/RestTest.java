package rest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rest.user.UserRequest;
import rest.user.CreateUserResponse;
import rest.user.User;
import utils.RestWrapper;
import utils.UserGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class RestTest {

    private static RestWrapper api;

    @BeforeTest
    public static void prepareUser() {
        api = RestWrapper.loginAs("don.digidon@reqres.in", "strongpwd");
    }

    @Test(description = "Получение списка всех существующих пользователей")
    public void getUsers() {
       assertThat(api.user.getUsers())
               .describedAs("Проверка электронной почты пользователя")
               .extracting(User::getEmail)
               .contains("george.bluth@reqres.in");
    }

    @Test(description = "Запрос на создание пользователя")
    public void createUserTest() {
        UserRequest userRequest = UserGenerator.getSimpleUser();
        CreateUserResponse response = api.user.createUser(userRequest);

        assertThat(response)
                .describedAs("Проверка результата ответа")
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(userRequest.getName());
    }
}
