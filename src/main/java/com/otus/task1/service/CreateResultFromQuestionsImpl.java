package com.otus.task1.service;

import com.otus.task1.model.Question;
import com.otus.task1.service.api.CheckAnswerFromQuestion;
import com.otus.task1.service.api.CreateResultFromQuestions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CreateResultFromQuestionsImpl implements CreateResultFromQuestions {

    private final CheckAnswerFromQuestion checkAnswerFromQuestion;

    public Map<String, Boolean> create(List<Question> questionFile, List<Question> questionUser) {
        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < questionFile.size(); i++) {
            Question questionFromFile = questionFile.get(i);
            Question questionFromUser = questionUser.get(i);

            map.put(questionFromFile.getValue(), checkAnswerFromQuestion.check(questionFromFile, questionFromUser));
        }

        return map;
    }

}
