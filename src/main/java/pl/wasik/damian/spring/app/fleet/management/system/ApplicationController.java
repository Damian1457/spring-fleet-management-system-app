package pl.wasik.damian.spring.app.fleet.management.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class ApplicationController {

    private static final Logger LOGGER = Logger.getLogger(ApplicationController.class.getName());

    @GetMapping("/index")
    public String index() {
        LOGGER.info("index()");
        return "index";
    }

    @GetMapping("/_layout")
    public String layout() {
        LOGGER.info("layout()");
        return "_layout";
    }

    @GetMapping("/hr")
    public String hr() {
        LOGGER.info("hr()");
        return "hr/index";
    }

    @GetMapping("/accounts")
    public String accounts() {
        LOGGER.info("accounts()");
        return "accounts/index";
    }

    @GetMapping("/fleet")
    public String fleet() {
        LOGGER.info("fleet()");
        return "fleet/index";
    }

    @GetMapping("/helpdesk")
    public String helpdesk() {
        LOGGER.info("helpdesk()");
        return "helpdesk/index";
    }

    @GetMapping("/parameters")
    public String parameters() {
        LOGGER.info("parameters()");
        return "parameters/index";
    }

    @GetMapping("/reports")
    public String reports() {
        LOGGER.info("reports()");
        return "reports/index";
    }

    @GetMapping("/security")
    public String security() {
        LOGGER.info("security()");
        return "security/index";
    }
}
