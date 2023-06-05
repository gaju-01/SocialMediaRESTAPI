package RESTAPI.SocialMediaRestAPI.User_Details;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserDefinedException extends RuntimeException {
    public UserDefinedException() {
        super("User Not Found!!");
    }
}
