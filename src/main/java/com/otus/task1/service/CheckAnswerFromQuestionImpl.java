package com.otus.task1.service;

import com.otus.task1.model.Answer;
import com.otus.task1.model.Question;
import com.otus.task1.service.api.CheckAnswerFromQuestion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckAnswerFromQuestionImpl implements CheckAnswerFromQuestion {

    @Override
    public boolean check(Question fromFile, Question fromUser) {
        if (fromFile == null || fromUser == null) return false;
        if (!fromFile.getValue().equals(fromUser.getValue())) return false;

        return checkAnswers(fromFile.getAnswers(), fromUser.getAnswers());
    }

    private boolean checkAnswers(List<Answer> fromFileAnswers, List<Answer> fromUserAnswers) {
        if (fromFileAnswers.size() != fromUserAnswers.size()) return false;
        List<Answer> toLowerCaseFromFileAnswers = toLowerCase(fromFileAnswers);
        List<Answer> toLowerCaseFromUserAnswers = toLowerCase(fromUserAnswers);

        return toLowerCaseFromFileAnswers.containsAll(toLowerCaseFromUserAnswers);
    }

    private List<Answer> toLowerCase(List<Answer> answers) {
        return answers.stream()
                .peek(answer -> answer.setValue(answer.getValue().toLowerCase()))
                .collect(Collectors.toList());
    }

}
