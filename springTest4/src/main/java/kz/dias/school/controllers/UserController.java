package kz.dias.school.controllers;

import kz.dias.school.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @PostMapping("/login")
    public Object checkLogin(@RequestBody User user) {
        if(user.getUsername().equals("admin") && user.getPassword().equals("admin"))
            return ResponseEntity.ok().body("Loged in as " + user.getUsername());
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
