package com.otus.task1.service;

import com.opencsv.CSVReader;
import com.otus.task1.config.CSVFileProperties;
import com.otus.task1.config.MessagesProperties;
import com.otus.task1.service.api.CSVParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CSVParserServiceImpl implements CSVParserService {

    private final CSVFileProperties csvFileProperties;
    private final MessagesProperties messagesProperties;

    @Override
    public List<String> parseCSVFile() {
        List<List<String>> records = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFileProperties.getUrl() + csvFileProperties.getName(), Charset.forName(messagesProperties.getCharset())))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records.stream()
                .map(list -> list.get(0))
                .collect(Collectors.toList());
    }

}
