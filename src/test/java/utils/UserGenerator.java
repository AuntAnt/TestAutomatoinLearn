package utils;

import rest.user.UserRequest;

public class UserGenerator {
    public static UserRequest getSimpleUser() {
        return UserRequest.builder()
                .name("Alex")
                .job("QA")
                .build();
    }
}
