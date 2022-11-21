package com.otus.task1;

import com.otus.task1.model.Answer;
import com.otus.task1.service.CreatorAnswerImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatorAnswerTest {

    @Test
    public void testCreateAnswer() {
        List<Answer> answers = new CreatorAnswerImpl().createAnswers("красный,черный");

        assertTrue(List.of("красный", "черный").containsAll(answers.stream()
                .map(Answer::getValue)
                .collect(Collectors.toList())));
    }

}
