package br.com.emmanuelneri.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private RefreshProperties refreshProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return refreshProperties.isHelloApiActive() ? "Hello" : "Inactive API";
    }

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String getClientName() {
        return refreshProperties.getClientName();
    }

}
