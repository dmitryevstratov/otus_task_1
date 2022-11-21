package com.otus.task1.service;

import com.otus.task1.config.MessagesProperties;
import com.otus.task1.model.Question;
import com.otus.task1.service.api.CSVParserService;
import com.otus.task1.service.api.CreateQuestionFromFile;
import com.otus.task1.service.api.CreatorQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CreateQuestionFromFileImpl implements CreateQuestionFromFile {

    private final CSVParserService csvParserService;
    private final CreatorQuestion creatorQuestion;
    private final MessagesProperties messagesProperties;

    @Override
    public List<Question> create() {
        List<String> rows = csvParserService.parseCSVFile();

        if (CollectionUtils.isEmpty(rows)) {
            System.out.println(messagesProperties.getEmptyFile());
            return null;
        } else {
            return rows.stream()
                    .map(creatorQuestion::create)
                    .collect(Collectors.toList());
        }
    }

}
