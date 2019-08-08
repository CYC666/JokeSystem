package com.system.joke.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRespond extends JpaRepository<UserModel, Integer> {



//    @Modifying
//    @Query(name = "update user set (gender, count) values ('男', 0) where id = :userId)", nativeQuery = true)
//    public void updateUser(int userId);

    @Modifying
    @Query(value = "update user set count = 0 where id = :userId", nativeQuery = true)
    public void updateUserWithId(int userId);

}
