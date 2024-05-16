package org.example.view;

import java.util.Scanner;

public class ProductReadByIdView {
    public String getData() {
        Scanner sc = new Scanner(System.in);
        String title = "Input id: ";
        System.out.println(title);
        return sc.nextLine();
    }
    public void getOutput(String output){
        System.out.println(output);
    }
}
