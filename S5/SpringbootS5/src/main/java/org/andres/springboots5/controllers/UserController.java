package org.andres.springboots5.controllers;

import org.andres.springboots5.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/users")
@RestController()
public class UserController {
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User user) {
        for (User existingUser : UsersGlobal.users.values()){
            if (existingUser.name.equals(user.name) && existingUser.password.equals(user.password)
            && existingUser.email.equals(user.email) && existingUser.role.equals(user.role)){
            return ResponseEntity.badRequest().body("User already exists");
            }
        }
        UsersGlobal.users.put(user.name, user);
        return ResponseEntity.ok("User added");
        }

        @GetMapping("/getAll")
        public Map<String, User> getAll() {
        return UsersGlobal.users;
    }

    @GetMapping("/getAllTeachers")
    public Map<String, User> getAllTeachers() {
        Map<String, User> result = new HashMap<>();
        for (User user : UsersGlobal.users.values()){
            result.put(user.name, user);
        }
        return result;
    }

    @GetMapping("/countTeachers&Students")
    public Map<String, Integer> countTeachersAndStudents() {
        int teacherCount = 0;
        int studentCount = 0;
        Map<String, Integer> result = new HashMap<>();
        for(User user : UsersGlobal.users.values()){
            if(user.role == Role.TEACHER){
                teacherCount++;
            } else if (user.role == Role.STUDENT){
                studentCount++;
            }
        }
        result.put("teachers", teacherCount);
        result.put("students", studentCount);
        return result;
    }
}
