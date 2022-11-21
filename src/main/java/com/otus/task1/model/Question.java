package com.otus.task1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Getter
@Setter
public class Question {

    private String value;
    private List<Answer> answers;

}
