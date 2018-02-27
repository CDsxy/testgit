package com.myweb.smis.domain;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private int score;
    private int age;
    private String name;
    private String gender;
    private String school;
}
