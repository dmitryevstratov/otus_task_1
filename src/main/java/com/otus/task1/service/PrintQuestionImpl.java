package com.otus.task1.service;

import com.otus.task1.config.MessagesProperties;
import com.otus.task1.model.Question;
import com.otus.task1.service.api.CSVParserService;
import com.otus.task1.service.api.CreatorAnswer;
import com.otus.task1.service.api.CreatorQuestion;
import com.otus.task1.service.api.PrintQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PrintQuestionImpl implements PrintQuestion {

    private final CSVParserService csvParserService;
    private final CreatorQuestion creatorQuestion;
    private final CreatorAnswer creatorAnswer;
    private final MessagesProperties messagesProperties;

    @Override
    public List<Question> createAnswersOnQuestionsFromUser() {
        List<String> rows = csvParserService.parseCSVFile();

        if (CollectionUtils.isEmpty(rows)) {
            System.out.println(messagesProperties.getCharset());
            return null;
        } else {
            return rows.stream()
                    .map(creatorQuestion::create)
                    .peek(question -> System.out.println(question.getValue()))
                    .peek(question -> question.setAnswers(
                            creatorAnswer.createAnswers(new Scanner(System.in).nextLine())
                    ))
                    .collect(Collectors.toList());
        }
    }

}
