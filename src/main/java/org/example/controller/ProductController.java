package org.example.controller;

import org.example.view.AppView;
import org.example.view.ProductCreateView;
import org.example.view.ProductReadByIdView;
import org.example.view.ProductReadView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductController {
    @Autowired
    AppView menuView;
    @Autowired
    ProductCreateView createView;
    @Autowired
    ProductReadView readView;
    @Autowired
    ProductReadByIdView productReadByIdView;

}
