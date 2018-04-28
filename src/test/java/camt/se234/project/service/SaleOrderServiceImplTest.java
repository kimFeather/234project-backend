package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import org.junit.Before;
import static org.mockito.Mockito.mock;

public class SaleOrderServiceImplTest {
    OrderDao orderDao;
    SaleOrderServiceImpl saleOrderService;

    @Before
    public void setup() {
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }
}
