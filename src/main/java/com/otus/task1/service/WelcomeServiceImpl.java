package com.otus.task1.service;

import com.otus.task1.config.MessagesProperties;
import com.otus.task1.service.api.WelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@RequiredArgsConstructor
@Service
public class WelcomeServiceImpl implements WelcomeService {

    private final MessagesProperties messagesProperties;

    @Override
    public String getFirstName() {
        Scanner in = new Scanner(System.in);
        System.out.print(messagesProperties.getFirstName());
        return in.nextLine();
    }

    @Override
    public String getSecondName() {
        Scanner in = new Scanner(System.in);
        System.out.print(messagesProperties.getSecondName());
        return in.nextLine();
    }

}
