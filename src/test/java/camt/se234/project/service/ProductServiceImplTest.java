package camt.se234.project.service;

import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {
    ProductDao productDao;
    ProductServiceImpl productService;

    @Before
    public void setup() {
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("KIM001", "Cocaine", "Im in love with the coco", "KIM001.jpg", 30.0));
        mockProducts.add(new Product("KIM002", "Ecstasy", "It's great for creater", "KIM002.jpg", 35.0));
        mockProducts.add(new Product("KIM003", "Marijuana", "Let's meets your god", "KIM003.jpg", 20.0));
        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getAllProducts(), hasItems(new Product("KIM001", "Cocaine", "Im in love with the coco", "KIM001.jpg", 30.0),
                new Product("KIM002", "Ecstasy", "It's great for creater", "KIM002.jpg", 35.0),
                new Product("KIM003", "Marijuana", "Let's meets your god", "KIM003.jpg", 20.0)));
    }

}
