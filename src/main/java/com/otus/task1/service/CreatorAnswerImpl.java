package com.otus.task1.service;

import com.otus.task1.model.Answer;
import com.otus.task1.service.api.CreatorAnswer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreatorAnswerImpl implements CreatorAnswer {

    @Override
    public List<Answer> createAnswers(String answers) {
        return Arrays.stream(answers.split(","))
                .map(s -> new Answer()
                        .setValue(s.replace("\"", "")))
                .collect(Collectors.toList());
    }

}
