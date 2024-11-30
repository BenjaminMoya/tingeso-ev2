package com.project.user_service.controller;

import com.project.user_service.entity.UserEntity;
import com.project.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> listUsers(){
        List<UserEntity> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        UserEntity user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getByRut/{rut}")
    public ResponseEntity<UserEntity> getUserByRut(@PathVariable String rut){
        UserEntity user = userService.getUserByRut(rut);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<UserEntity> getUserByEmail(@PathVariable String email){
        UserEntity user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/save")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        UserEntity newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserEntity> login(@RequestBody UserEntity user){
        System.out.println("Login");
        return ResponseEntity.ok(userService.login(user.getUserEmail(),user.getUserPassword()));
    }

    @PutMapping("/update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user){
        UserEntity userUpdated = userService.updateUser(user);
        return ResponseEntity.ok(userUpdated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable Long id) throws Exception {
        var isDeleted = userService.deleteUser(id);
        return ResponseEntity.ok(isDeleted);
    }

    @PostMapping("/setZero/{id}")
    public int zeroSaving(@PathVariable long id){
        return userService.zeroSaving(id);
    }

    @PostMapping("/transfer")
    public double transferAmount(@RequestBody Map<String, Object> body){
        long userId = Long.parseLong(body.get("userId").toString());
        long creditId = Long.parseLong(body.get("creditId").toString());
        return userService.transferAmount(userId,creditId);
    }
}
