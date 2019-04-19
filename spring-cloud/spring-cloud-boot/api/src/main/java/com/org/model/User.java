package com.org.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final Long serialVersionUID=129834034563408534l;
    private String name;
    private int age;
}
