package org.example.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductDeleteView {
    public String getData(){
        Scanner sc = new Scanner(System.in);
        String title = "Input id: ";
        System.out.println(title);
        return sc.nextLine().trim();
    }
    public void getOutput(String output){
        System.out.println(output);
    }
}
