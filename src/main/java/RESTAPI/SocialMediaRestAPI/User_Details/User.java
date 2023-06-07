package RESTAPI.SocialMediaRestAPI.User_Details;

import java.util.*;
import java.time.LocalDate;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import RESTAPI.SocialMediaRestAPI.Post_Details.Post;

@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Column(name = "name")
    @Size(min = 2, message = "Name should contain  atleast two characters")
    @JsonProperty("name")
    private String name;

    @Column(name = "birth_date")
    @Past(message = "The data should be of the past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @Column(name = "nick_name")
    @JsonProperty("nick_name")
    private String nickName;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> post_details;

    protected User() {

    }

    public User(String name, LocalDate birthDate, String nickName, int id) {
        this.name = name;
        this.nickName = nickName;
        this.birthDate = birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosts(List<Post> post_details) {
        this.post_details = post_details;
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

    public List<Post> getPosts() {
        return this.post_details;
    }

    public String toString() {
        return "User: " + this.id + " " + this.name + " " + this.birthDate;
    }
}
