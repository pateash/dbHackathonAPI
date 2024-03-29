package com.db.dbhackathonapi.Tables;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;


@ToString
@Setter
@Getter
@Entity // This tells Hibernate to make a table out of this class
public class User {

    private int id;

    @Id
    private String email;
    private String name;
    private String password;
    private Timestamp timestamp;

}