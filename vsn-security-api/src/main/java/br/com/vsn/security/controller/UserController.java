package br.com.vsn.security.controller;

import br.com.vsn.security.model.User;
import br.com.vsn.security.model.UserDTO;
import br.com.vsn.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }

    @GetMapping("/login/{login}")
    public User list(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @PostMapping
    public void post(@RequestBody UserDTO userDTO) {
        // TODO Tratar login já existente.
        userService.insert(userDTO);
    }

}
