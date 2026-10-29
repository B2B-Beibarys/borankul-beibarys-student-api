package com.borankul.studentapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Value("${student.owner:Beibarys Borankul}")
    private String owner;

    @Value("${app.version:1.0.0}")
    private String version;

    @GetMapping("/")
    public Map<String, String> info() {
        return Map.of(
            "application", "Student API",
            "author", owner,
            "group", "IT2-2306",
            "studentId", "38293",
            "version", version
        );
    }
}
