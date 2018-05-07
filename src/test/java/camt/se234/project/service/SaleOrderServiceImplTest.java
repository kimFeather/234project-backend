package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleOrderServiceImplTest {
    OrderDao orderDao;
    SaleOrderServiceImpl saleOrderService;

    @Before
    public void setup() {
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }

    @Test
    public void testGetSaleOrders() {
        List<SaleTransaction> mockTransactions1 = new ArrayList<>();
        List<SaleTransaction> mockTransactions2 = new ArrayList<>();
        mockTransactions1.add(new SaleTransaction("Transac1", new SaleOrder("SaleOrder1", mockTransactions1),
                new Product("KIM004", "AK-47", "allahu akbar", "KIM004.jpg", 400.0), 1));
        mockTransactions1.add(new SaleTransaction("Transac2", new SaleOrder("SaleOrder1", mockTransactions1),
                new Product("KIM005", "Heroin", "make u feel in a dreamy state", "KIM005.jpg", 200.0), 1));
        mockTransactions2.add(new SaleTransaction("Transac3", new SaleOrder("SaleOrder2", mockTransactions2),
                new Product("KIM006", "Meth", "party n play", "KIM006.jpg", 30.0), 10));
        mockTransactions2.add(new SaleTransaction("Transac4", new SaleOrder("SaleOrder2", mockTransactions2),
                new Product("KIM007", "Counterfeit US Dollars", "Ez rich", "KIM007.jpg", 1.0), 5));
        List<SaleOrder> mockOrders = new ArrayList<>();
        mockOrders.add(new SaleOrder("SaleOrder1", mockTransactions1));
        mockOrders.add(new SaleOrder("SaleOrder2", mockTransactions2));
        when(orderDao.getOrders()).thenReturn(mockOrders);
        assertThat(saleOrderService.getSaleOrders(), hasItems(new SaleOrder("SaleOrder1", mockTransactions1),
                new SaleOrder("SaleOrder2", mockTransactions2)));
    }

    @Test
    public void testAverageSaleOrderPrice() {
        List<SaleTransaction> mockTransactions1 = new ArrayList<>();
        List<SaleTransaction> mockTransactions2 = new ArrayList<>();
        mockTransactions1.add(new SaleTransaction("Transac1", new SaleOrder("SaleOrder1", mockTransactions1),
                new Product("KIM004", "AK-47", "allahu akbar", "KIM004.jpg", 400.0), 1));
        mockTransactions1.add(new SaleTransaction("Transac2", new SaleOrder("SaleOrder1", mockTransactions1),
                new Product("KIM005", "Heroin", "make u feel in a dreamy state", "KIM005.jpg", 200.0), 1));
        mockTransactions2.add(new SaleTransaction("Transac3", new SaleOrder("SaleOrder2", mockTransactions2),
                new Product("KIM006", "Meth", "party n play", "KIM006.jpg", 30.0), 10));
        mockTransactions2.add(new SaleTransaction("Transac4", new SaleOrder("SaleOrder2", mockTransactions2),
                new Product("KIM007", "Counterfeit US Dollars", "Ez rich", "KIM007.jpg", 1.0), 5));
        List<SaleOrder> mockOrders = new ArrayList<>();
        mockOrders.add(new SaleOrder("SaleOrder1", mockTransactions1));
        mockOrders.add(new SaleOrder("SaleOrder2", mockTransactions2));
        when(orderDao.getOrders()).thenReturn(mockOrders);
        assertThat(saleOrderService.getAverageSaleOrderPrice(), is(closeTo(226.25, 0.01)));
    }
}
