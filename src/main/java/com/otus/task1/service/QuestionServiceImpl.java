package com.otus.task1.service;

import com.otus.task1.model.Question;
import com.otus.task1.model.Result;
import com.otus.task1.service.api.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final WelcomeService welcomeService;
    private final PrintQuestion printQuestion;
    private final CreateQuestionFromFile createQuestionFromFile;
    private final CreateResultFromQuestions createResultFromQuestions;
    private Result result;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void startTest() {

        result = new Result()
                .setFirstName(welcomeService.getFirstName())
                .setSecondName(welcomeService.getSecondName());
        List<Question> answersOnQuestionsFromUser = printQuestion.createAnswersOnQuestionsFromUser();
        List<Question> answersOnQuestionsFromFile = createQuestionFromFile.create();

        result.setResults(createResultFromQuestions.create(answersOnQuestionsFromFile, answersOnQuestionsFromUser));

        printResult();
    }

    @Override
    public void printResult() {
        System.out.println(result);
    }


}
