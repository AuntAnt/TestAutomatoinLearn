package rest.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import utils.DateDeserializer;

import java.time.LocalDateTime;

@Data
public class CreateUserResponse extends UserRequest{
    private int id;
    //форматирование даты в строку по паттерну
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
    //обратная десереализация
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
}
