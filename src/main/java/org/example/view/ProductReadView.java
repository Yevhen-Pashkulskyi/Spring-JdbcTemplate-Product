package org.example.view;

import org.springframework.stereotype.Component;

@Component
public class ProductReadView {
    public void getOutput(String output) {
        System.out.println(output);
    }
}
