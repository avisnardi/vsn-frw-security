package br.com.vsn.security.repository;

import br.com.vsn.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    List<User> findAll();


    User findByLogin(String login);
}
