package com.statify.api.controller;

import com.statify.api.model.DAOUser;
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
    public DAOUser create(@RequestBody DAOUser user) { //Mauvaise pratique ! Normalement on met des DDO qui recoivent des donnee puis on utilise un modelmapper
        return userService.create(user);
    }

    @GetMapping("/read")
    public List<DAOUser> read() {
        return userService.read();
    }

    @GetMapping("/readByEmail")
    public DAOUser readByEmail(@RequestBody DAOUser user) {
        return userService.getByUsername(user.getUsername());
    }

    @PutMapping("/update/{id}")
    public DAOUser update(@PathVariable UUID id, @RequestBody DAOUser user) {
        return userService.update(id, user);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable UUID id) {
        return userService.delete(id);
    }

}
