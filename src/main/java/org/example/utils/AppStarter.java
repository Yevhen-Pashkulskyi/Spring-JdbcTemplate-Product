package org.example.utils;

import org.example.conf.AppConfig;
import org.example.controller.ProductController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppStarter {
    public static void startApp(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductController productController = context.getBean(ProductController.class);
        productController.getOption();

        context.close();
    }
}
