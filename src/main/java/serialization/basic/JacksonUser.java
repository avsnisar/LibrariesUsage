package serialization.basic;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonValue;

public class JacksonUser {

//    @JsonProperty("indentifier")
    public Integer id;
    private String firstName;

//    @JsonGetter("name")
    public String getFirstName() {
        return firstName;
    }

    @JsonGetter
    public String getLastName(){
        return "Jackson";
    }

    public JacksonUser() {
    }

    public JacksonUser(Integer id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "JacksonUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    @JsonValue
    public String fieldsValues(){
        return this.id + ", " + this.firstName;
    }
}
