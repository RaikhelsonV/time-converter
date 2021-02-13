package com.example.HebrewDateConverter;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class DateController {
    private DateService service;

    @Autowired
    public DateController(DateService service) {
        this.service = service;
    }

    @GetMapping("hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping(value = "{gy}/{gm}/{gd}")
    public ResponseEntity<String> read(@PathVariable String gy, @PathVariable String gm, @PathVariable String gd) throws UnirestException {
        String result = service.converterGregToJew(gy, gm, gd);
        return ResponseEntity.ok(result);
    }
}
