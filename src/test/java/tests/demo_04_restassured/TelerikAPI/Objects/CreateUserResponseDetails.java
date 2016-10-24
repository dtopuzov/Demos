package tests.demo_04_restassured.TelerikAPI.Objects;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "CreatedAt"
})
public class CreateUserResponseDetails {

    @JsonProperty("Id")
    public String id;
    @JsonProperty("CreatedAt")
    public String createdAt;

}