package pl.wasik.damian.spring.app.fleet.management.system.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class ApplicationController {

    private static final Logger LOGGER = Logger.getLogger(ApplicationController.class.getName());

    @GetMapping("/_layout")
    public String create() {
        LOGGER.info("create()");
        return "_layout";
    }

    @GetMapping("/index2")
    public String get() {
        LOGGER.info("get()");
        return "index2";
    }
}
