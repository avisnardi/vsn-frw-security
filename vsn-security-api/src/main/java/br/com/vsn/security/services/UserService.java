package br.com.vsn.security.services;

import br.com.vsn.security.model.User;
import br.com.vsn.security.model.UserDTO;
import br.com.vsn.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService   {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User findByLogin(String login) {
            return userRepository.findByLogin(login);
    }

    public void insert(UserDTO userDTO) {
        System.out.println("userDTO:" + userDTO);

        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        String passwordHash = (new BCryptPasswordEncoder()).encode(userDTO.getPassword());
        user.setPasswordHash(passwordHash);
        userRepository.save(user);
    }
}
