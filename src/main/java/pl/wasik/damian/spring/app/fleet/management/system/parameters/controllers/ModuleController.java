package pl.wasik.damian.spring.app.fleet.management.system.parameters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModuleController {

    @GetMapping("/parameters/modules")
    public String getModules(){
        return "modules";
    }

}
