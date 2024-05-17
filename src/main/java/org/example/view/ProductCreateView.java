package org.example.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductCreateView {
    public String[] getData() {
        Scanner sc = new Scanner(System.in);
        String title = "Input name product: ";
        System.out.println(title);
        String name = sc.nextLine().trim();
        title = "Input quota: ";
        System.out.println(title);
        String quota = sc.nextLine().trim();
        title = "Input price: ";
        System.out.println(title);
        String price = sc.nextLine().trim();
        return new String[]{name, quota, price};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
