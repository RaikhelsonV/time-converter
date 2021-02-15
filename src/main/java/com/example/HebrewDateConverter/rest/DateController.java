package com.example.HebrewDateConverter.rest;

import com.example.HebrewDateConverter.service.DateService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
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

    @PostMapping(value = "{gy}/{gm}/{gd}")
    public ResponseEntity<JewishDate> read(@PathVariable String gy, @PathVariable String gm, @PathVariable String gd) throws UnirestException {
        return ResponseEntity.ok(new JewishDate(service.converterGregToJew(gy, gm, gd)));
    }

    private class JewishDate {
        String date;

        public JewishDate() {
        }

        public JewishDate(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "JewishDate{" +
                    "date='" + date + '\'' +
                    '}';
        }
    }
}
