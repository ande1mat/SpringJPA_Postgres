package com.springjpa;

import com.springjpa.dto.CartDto;
import com.springjpa.dto.CustomerDto;
import com.springjpa.repository.CustomerRepository;
import com.springjpa.repository.CartRepository;
import com.springjpa.service.CustomerService;
import com.springjpa.model.Customer;
import com.springjpa.model.Cart;
import org.mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
public class MockServiceUnitTests {

    @Mock
    private CustomerRepository daoCustomerMock;

    @Mock
    private CartRepository daoCartMock;


    @InjectMocks
    private CustomerService service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testServiceFindCustomer() {

        int i=16;
        Long l = new Long(i);

        when(daoCustomerMock.findByid(l)).thenReturn(new Customer());
        CustomerDto customerdto = service.getCustById(l);
        assertEquals(customerdto, service.getCustById(l));

    }



    @Test
    public void testServiceSaveCustomer() {

        when(daoCustomerMock.save(any(Customer.class))).thenReturn(new Customer());
        Customer customer = new Customer();
        assertEquals(customer, service.saveCustomer(customer));

    }


    @Test
    public void testServiceDeleteCustomer() {

        int i=16;
        Long l = new Long(i);

        when(daoCustomerMock.findByid(l)).thenReturn(new Customer());
        service.deleteCustomer(l);
        verify(daoCustomerMock, times(1)).delete(new Customer());

    }


    @Test
    public void testServiceUpdateCustomer() {

        //int i=16;
        //Long l = new Long(i);

        //when(daoCustomerMock.save(any(Customer.class))).thenReturn(new Customer());
        //Customer customer = new Customer();
        //(Long id, String fname, String lname, String htown
        //System.out.println(service.updateCustomer(any(), any(), any(), any()));
        //Customer cust = service.updateCustomer(1L, "test", "test", "test");
        //assertEquals(customer, service.updateCustomer());


    }



    @Test
    public void testServiceFindCart() {

        int i=16;
        Long l = new Long(i);

        when(daoCartMock.findByIdAndCustid(l, l)).thenReturn(new Cart());
        CartDto cartdto = service.getCartByCustId(l,l);
        assertEquals(cartdto, service.getCartByCustId(l,l));

    }


    @Test
    public void testServiceSaveCart() {

        when(daoCartMock.save(any(Cart.class))).thenReturn(new Cart());
        Cart cart = new Cart();
        assertEquals(cart, service.saveCart(cart));

    }

    @Test
    public void testServiceDeleteCart() {

        int i=16;
        Long l = new Long(i);

        when(daoCartMock.findByid(l)).thenReturn(new Cart());
        service.deleteCart(l);
        verify(daoCartMock, times(1)).delete(new Cart());

    }

}
