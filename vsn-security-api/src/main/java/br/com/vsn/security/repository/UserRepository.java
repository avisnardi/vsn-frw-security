package br.com.vsn.security.repository;

import br.com.vsn.security.model.User;
import br.com.vsn.security.model.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();

    Optional<User>  findByEmail(String email);
}
