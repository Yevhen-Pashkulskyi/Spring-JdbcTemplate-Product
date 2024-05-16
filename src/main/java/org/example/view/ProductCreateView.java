package org.example.view;

import java.util.Scanner;

public class ProductCreateView {
    public String[] getData() {
        Scanner sc = new Scanner(System.in);
        String title = "Input name product: ";
        System.out.println(title);
        String name = sc.nextLine().trim();
        title = "Input quota: ";
        System.out.println(title);
        int quota = sc.nextInt();
        title = "Input price: ";
        System.out.println(title);
        double price = sc.nextDouble();
        return new String[]{title, name, String.valueOf(quota), String.valueOf(price)};
    }
    public void getOutput(String output){
        System.out.println(output);
    }
}
