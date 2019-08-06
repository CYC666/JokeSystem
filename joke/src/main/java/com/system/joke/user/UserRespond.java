package com.system.joke.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespond extends JpaRepository<UserModel, Integer> {
}
