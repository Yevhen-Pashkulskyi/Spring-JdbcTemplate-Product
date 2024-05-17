package org.example.view;

import org.example.utils.Constants;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class AppView {
    Scanner sc = new Scanner(System.in);

    public String getOption() {
        showMenu();
        String option = "";
        try {
            option = sc.nextLine().trim();
        } catch (InputMismatchException e) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
        }
        return option;
    }

    public void showMenu() {
        System.out.println("""
                Menu
                1- Create Product
                2- Show All Products
                3- Show product by ID
                4- Update product
                5- Delete product
                0- Exit program.""");

        System.out.println("Input your choice: ");
    }

    public void getOutput(String output) {
        if (output.equals(Constants.APP_CLOSE_MSG))
            System.out.println(output);
        sc.close();
        System.exit(0);
    }
}
