package RESTAPI.SocialMediaRestAPI;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "User")
public class User {
    @Id
    @JsonProperty("id")
    private Integer id;

    @Column(name = "name")
    @Size(min = 2, message = "Name should contain  atleast two characters")
    @JsonProperty("name")
    private String name;

    @Column(name = "birthDate")
    @Past(message = "The data should be of the past")
    @JsonProperty("birth-date")
    private LocalDate birthDate;

    @Column(name = "nickname")
    @JsonProperty("nick-name")
    private String nickName;

    public User(Integer id, String name, LocalDate birthDate, String nickName) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.nickName = nickName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public String toString() {
        return "User: " + this.id + " " + this.name + " " + this.birthDate;
    }
}
