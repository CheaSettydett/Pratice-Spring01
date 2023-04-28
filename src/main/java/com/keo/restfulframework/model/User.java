package com.keo.restfulframework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors (chain = true)
public class User {
    private int userID;
    private String name;
    private String gender;
    private String address;

}
