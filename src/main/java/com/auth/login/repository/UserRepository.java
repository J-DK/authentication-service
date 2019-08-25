package com.auth.login.repository;

import com.auth.login.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User save(User user);

    User findByEmail(String email);
}
