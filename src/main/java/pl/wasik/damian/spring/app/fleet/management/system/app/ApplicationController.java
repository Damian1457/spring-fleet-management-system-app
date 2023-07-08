package pl.wasik.damian.spring.app.fleet.management.system.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class ApplicationController {

    private static final Logger LOGGER = Logger.getLogger(ApplicationController.class.getName());

    @GetMapping("/_layout")
    public String home() {
        LOGGER.info("home()");
        return "_layout";
    }

    @GetMapping("/hr")
    public String widget() {
        LOGGER.info("widget()");
        return "hr/index";
    }
}
