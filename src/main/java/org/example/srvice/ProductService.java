package org.example.srvice;

import org.example.entity.Product;
import org.example.exception.ProductDataException;
import org.example.repository.impl.ProductRepository;
import org.example.utils.Constants;
import org.example.utils.ReggexValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ProductService {
    @Autowired
    Product product;
    @Autowired
    ProductRepository productRepository;
    Map<String, String> errors = new HashMap<>();

    public String create(Product product) {
        validateDat(product);
        if (!errors.isEmpty()) {
            try {
                throw new ProductDataException("Check inputs", errors);
            } catch (ProductDataException e) {
                return e.getErrors(errors);
            }
        }
        if (productRepository.create(product)) {
            return Constants.DATA_INSERT_MSG;
        } else {
            return Constants.SMTH_WRONG_MSG;
        }
    }

    public String getAll() {
        Optional<List<Product>> optional = productRepository.fetchAll();
        if (optional.isEmpty()) {
            return Constants.DATA_ABSENT_MSG;
        } else {
            AtomicInteger count = new AtomicInteger(0);
            StringBuilder builder = new StringBuilder();
            List<Product> productList = optional.get();
            productList.forEach(product ->
                    builder.append(count.incrementAndGet())
                            .append(") ")
                            .append(product.toString()));
            return builder.toString();
        }
    }

    public String getById(String id) {
        validateRegx(id);
        if (!errors.isEmpty()) {
            try {
                throw new ProductDataException("Check inputs", errors);
            } catch (ProductDataException e) {
                return e.getErrors(errors);
            }
        }
        Optional<Product> optional = productRepository.findById(Long.parseLong(id));
        if (optional.isEmpty()) {
            return Constants.DATA_ABSENT_MSG;
        }else {
            Product product = optional.get();
            return product.toString();
        }

    }

    public String update(Product product) {
        validateDat(product);
        validateRegx(String.valueOf(product.getId()));
        if (!errors.isEmpty()) {
            try{
                throw new ProductDataException("Check inputs", errors);
            }catch (ProductDataException e){
                return e.getErrors(errors);
            }
        }
        if (productRepository.update(product)) {
            return Constants.DATA_UPDATE_MSG;
        }else {
            return Constants.SMTH_WRONG_MSG;
        }
    }

    public String delete(String id) {
        validateRegx(id);
        if (!errors.isEmpty()) {
            try{
                throw new ProductDataException("Check inputs", errors);
            }catch (ProductDataException e){
                return e.getErrors(errors);
            }
        }
        product.setId(Long.parseLong(id));
        if (productRepository.delete(product)) {
            return Constants.DATA_DELETE_MSG;
        }else {
            return Constants.SMTH_WRONG_MSG;
        }
    }

    private void validateDat(Product product) {
        if (product.getName().isEmpty()){
            errors.put("name", Constants.INPUT_REQ_MSG);
        }
        if (product.getQuota().isEmpty()){
            errors.put("quota", Constants.INPUT_REQ_MSG);
        }
        if (product.getPrice().isEmpty()){
            errors.put("price", Constants.INPUT_REQ_MSG);
        }
    }

    private void validateRegx(String id) {
        if (ReggexValidator.isValid(id)){
            errors.put("id", Constants.ID_ERR_MSG);
        }
    }

}
