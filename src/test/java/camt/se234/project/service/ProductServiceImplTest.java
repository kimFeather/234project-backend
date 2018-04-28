package camt.se234.project.service;

import camt.se234.project.dao.ProductDao;
import org.junit.Before;

import static org.mockito.Mockito.mock;

public class ProductServiceImplTest {
    ProductDao productDao;
    ProductServiceImpl productService;

    @Before
    public void setup() {
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }

}
