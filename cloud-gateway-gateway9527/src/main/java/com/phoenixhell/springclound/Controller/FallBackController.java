package com.phoenixhell.springclound.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/fallback")
    public String fallback() {
        return "Error:fallback";
    }

}