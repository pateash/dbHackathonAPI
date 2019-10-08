package com.db.dbhackathonapi.interfaces;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@Getter
@Setter
public class Activity {
         String userEmail;
         int ghgFootprint;
         Timestamp timestamp;
}
