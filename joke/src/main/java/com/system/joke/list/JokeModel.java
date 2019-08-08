package com.system.joke.list;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "joke_list")
public class JokeModel {

    @Id
    int id;

    @Column
    String content;

    @Column
    String creatTime;



}
