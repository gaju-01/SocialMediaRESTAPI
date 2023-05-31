package RESTAPI.SocialMediaRestAPI.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("person/v1")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("person/v2")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionThroughParamerters() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionThroughParamerters() {
        return new PersonV2(new Name("Blob", "Charlie"));
    }

    @GetMapping(path = "/person/api", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionThroughHeaders() {
        return new PersonV1("Blob Charlie");
    }

    @GetMapping(path = "/person/api", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionThroughHeaders() {
        return new PersonV2(new Name("Blob", "Charlie"));
    }

}
