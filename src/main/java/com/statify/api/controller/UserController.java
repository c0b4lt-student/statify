package com.statify.api.controller;

import com.statify.api.model.User;
import com.statify.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService; //inversion de controle + injection de dep

    @PostMapping("/create")
    public User create(@RequestBody User user) { //Mauvaise pratique ! Normalement on met des DDO qui recoivent des donnee puis on utilise un modelmapper
        return userService.create(user);
    }

    @GetMapping("/read")
    public List<User> read() {
        return userService.read();
    }

    @GetMapping("/readByEmail")
    public User readByEmail(@RequestBody User user) {
        return userService.getByUsername(user.getUsername());
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable UUID id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable UUID id) {
        return userService.delete(id);
    }
}
