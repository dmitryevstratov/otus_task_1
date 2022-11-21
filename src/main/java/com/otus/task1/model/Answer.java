package com.otus.task1.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@EqualsAndHashCode
@Accessors(chain = true)
@Getter
@Setter
public class Answer {

    private String value;

}
