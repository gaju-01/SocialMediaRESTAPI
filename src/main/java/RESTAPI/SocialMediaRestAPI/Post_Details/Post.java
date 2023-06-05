package RESTAPI.SocialMediaRestAPI.Post_Details;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import RESTAPI.SocialMediaRestAPI.User_Details.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "post_details")
public class Post {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Post: " + this.id + " " + this.description;
    }
}
