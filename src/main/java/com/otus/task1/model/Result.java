package com.otus.task1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

@Accessors(chain = true)
@Getter
@Setter
public class Result {

    private String firstName;
    private String secondName;
    private Map<String, Boolean> results;

    @Override
    public String toString() {
        return "Имя: " + firstName + "\n" +
                "Фамилия: " + secondName + "\n" +
                "Результаты:" + "\n" +
                results;
    }
}
