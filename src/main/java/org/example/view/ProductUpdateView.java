package org.example.view;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class ProductUpdateView {
    public Map<String, String> getData() {
        Map<String, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String title = "Input name product: ";
        System.out.print(title);
        map.put("name", sc.nextLine().trim());
    }
}
