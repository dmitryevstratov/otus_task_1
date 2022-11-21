package com.otus.task1.service;

import com.otus.task1.model.Question;
import com.otus.task1.service.api.CreatorAnswer;
import com.otus.task1.service.api.CreatorQuestion;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreatorQuestionImpl implements CreatorQuestion {

    private final CreatorAnswer creatorAnswer;

    @Override
    public Question create(String row) {
        if (StringUtils.isBlank(row)) return null;

        String[] rows = row.split("\\?;");

        return new Question()
                .setValue(rows[0])
                .setAnswers(creatorAnswer.createAnswers(rows[1]));
    }
}
