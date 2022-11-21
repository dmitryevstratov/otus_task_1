package com.otus.task1.service.api;

import com.otus.task1.model.Question;

public interface CheckAnswerFromQuestion {

    boolean check(Question fromFile, Question fromUser);

}
