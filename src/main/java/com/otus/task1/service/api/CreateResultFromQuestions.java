package com.otus.task1.service.api;

import com.otus.task1.model.Question;

import java.util.List;
import java.util.Map;

public interface CreateResultFromQuestions {

    public Map<String, Boolean> create(List<Question> questionFile, List<Question> questionUser);

}
