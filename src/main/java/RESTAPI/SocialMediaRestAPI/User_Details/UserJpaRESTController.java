package RESTAPI.SocialMediaRestAPI.User_Details;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import RESTAPI.SocialMediaRestAPI.Post_Details.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import RESTAPI.SocialMediaRestAPI.Post_Details.PostJPARepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaRESTController {
    private UserRepo userRepo;
    private PostJPARepo postRepo;

    @Autowired
    public UserJpaRESTController(UserRepo userRepo, PostJPARepo postRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public User getOneUser(@PathVariable int id) {
        Optional<User> user = this.userRepo.findById(id);

        if (user.isEmpty()) {
            throw new UserDefinedException();
        }

        return user.get();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = this.userRepo.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userRepo.deleteById(id);
    }

    @GetMapping("jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> user = this.userRepo.findById(id);
        if (user.isEmpty()) {
            throw new UserDefinedException();
        }
        return user.get().getPosts();
    }

    @PostMapping("jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @RequestBody Post post) {
        Optional<User> opUser = this.userRepo.findById(id);

        if (opUser.isEmpty()) {
            throw new UserDefinedException();
        }
        post.setUser(opUser.get());
        Post savedPost = this.postRepo.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
