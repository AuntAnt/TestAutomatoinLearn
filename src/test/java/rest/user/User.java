package rest.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Класс для хранения данных (Pojo class)
 */

//игнорирование полей, которые есть в json, но не описаны в классе
@Data //ломбок генерирует геттеры и сеттеры
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;
    private String email;
    @JsonProperty("first_name") //аннотация указывает на название тега в json,
    //если переменная в java называется по-другому
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    //private String avatar; - будет проигнорировано в json
}
