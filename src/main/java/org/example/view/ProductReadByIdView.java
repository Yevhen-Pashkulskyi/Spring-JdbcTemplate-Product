package org.example.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductReadByIdView {
    public String getData() {
        Scanner sc = new Scanner(System.in);
        String title = "Input id: ";
        System.out.print(title);
        return sc.nextLine();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
