package RESTAPI.SocialMediaRestAPI.User_Details;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.function.Predicate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;
    // static {
    // users.add(new User(++usersCount, "Gajanan C Hegde",
    // LocalDate.now().minusYears(1), "gaju_01"));
    // users.add(new User(++usersCount, "Sumukha TS", LocalDate.now().minusYears(5),
    // "BlackDread"));
    // users.add(new User(++usersCount, "Dhruva S", LocalDate.now().minusYears(10),
    // "dhruva_shashi"));
    // }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        User user = users.stream().filter(predicate).findFirst().orElse(null);
        if (user != null) {
            users.remove(user);
        }
    }
}
