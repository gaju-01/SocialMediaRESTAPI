package RESTAPI.SocialMediaRestAPI.HelloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")
    public String retString() {
        return "Hello World!!";
    }

    @GetMapping(path = "/hello-word-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    // building a simple url accepting the path parameters
    @GetMapping(path = "/path-variable/{name}")
    public HelloWorldBean returnPathVarBean(@PathVariable String name) {
        return new HelloWorldBean("This is the path variable " + name);
    }

    @GetMapping(path = "/path-variables/{id}")
    public String returnId(@PathVariable Long id) {
        return "returning the Id....." + Long.toString(id);
    }

    @GetMapping(path = "/path-variables-custom/{name}/{id}")
    public String returnCustomPath(@PathVariable String name, @PathVariable Long id) {
        StringBuffer buff = new StringBuffer();
        buff.append("Returning the custom path...........");
        buff.append(name);
        buff.append(" ");
        buff.append(Long.toString(id));

        return buff.toString();
    }

    @GetMapping(path = "/hello-world-Internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return this.messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }

}