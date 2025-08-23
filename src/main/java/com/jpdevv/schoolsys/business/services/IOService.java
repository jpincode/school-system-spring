package com.jpdevv.schoolsys.business.services;

import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class IOService {
    private Scanner scanner = new Scanner(System.in);

    public void print(String text) {
        System.out.println(text);
    }

    public void print(String text, boolean newLine) {
        if (!newLine) {
            System.out.print(text);
        }
    }

    public String read(String prompt) {
        this.print(prompt, false);
        return scanner.nextLine();
    }
}