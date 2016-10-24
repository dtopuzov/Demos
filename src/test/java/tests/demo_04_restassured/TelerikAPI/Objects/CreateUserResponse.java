package tests.demo_04_restassured.TelerikAPI.Objects;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "Result" })
public class CreateUserResponse {

    @JsonProperty("Result")
    public CreateUserResponseDetails result;

}
