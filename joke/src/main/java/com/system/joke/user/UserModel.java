package com.system.joke.user;


import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data   // 自动实现get、set
@Entity
@Table(name="user")
public class UserModel {

    @Id
    int id;

    @Column
    String name;

    @Column
    String phone;

    @Column
    Integer count;

    @Column
    String gender;


}
