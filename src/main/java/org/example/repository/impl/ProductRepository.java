package org.example.repository.impl;

import org.example.entity.Product;
import org.example.entity.ProductMapper;
import org.example.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository implements AppRepository<Product> {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public boolean create(Product obj) {
        String sql = "INSERT INTO product (name, quota, price) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, obj.getName(), obj.getQuota(), obj.getPrice()) > 0;
    }

    @Override
    public Optional<List<Product>> fetchAll() {
        String sql = "SELECT * FROM product";
        Optional<List<Product>> optional;
        try {
            optional = Optional.of(jdbcTemplate
                    .query(sql, new ProductMapper()));
        } catch (Exception e) {
            optional = Optional.empty();
        }
        return optional;
    }

    public Optional<Product> fetchById(Long id) {
        String sql = "SELECT * FROM product WHERE id = ? LIMIT 1";
        Optional<Product> optional;
        try {
            optional = Optional.ofNullable(jdbcTemplate
                    .queryForObject(sql, new ProductMapper(), id));
        } catch (Exception e) {
            optional = Optional.empty();
        }
        return optional;
    }

    @Override
    public boolean update(Product obj) {
        Optional<Product> optional = fetchById(obj.getId());
        if (optional.isEmpty()) return false;
        else {
            String sql = "UPDATE product SET name = ?, quota = ?, price = ? WHERE id = ?";
            return jdbcTemplate.update(sql, obj.getName(), obj.getQuota(), obj.getPrice(), obj.getId()) > 0;
        }
    }

    @Override
    public boolean delete(Product obj) {
        Optional<Product> optional = fetchById(obj.getId());
        if (optional.isEmpty()) return false;
        else {
            String sql = "DELETE FROM product WHERE id = ?";
            return jdbcTemplate.update(sql, obj.getId()) > 0;
        }
    }
}
