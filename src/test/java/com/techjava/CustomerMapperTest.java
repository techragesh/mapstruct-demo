package com.techjava;

import com.techjava.dto.Customer;
import com.techjava.dto.CustomerDto;
import com.techjava.dto.OrderItem;
import com.techjava.dto.OrderItemDto;
import com.techjava.mapper.CustomerMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.tuple;

public class CustomerMapperTest {

    @Test
    public void testMapDtoToEntity(){

        CustomerDto customerDto = new CustomerDto();
        customerDto.customerName ="Dave";
        customerDto.id = 100L;

        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.name = "iPhone";
        orderItemDto.quantity=1L;
        customerDto.orders = new ArrayList<>(Collections.singleton(orderItemDto));

        Customer customer = CustomerMapper.MAPPER.toCustomer(customerDto);

        System.out.println(customer.toString());
        assertThat(customer.getId()).isEqualTo(100L);
        assertThat(customer.getName()).isEqualTo("Dave");
        assertThat(customer.getOrderItems()).extracting("name","quantity").containsExactly(tuple("iPhone", 1L));
    }

    @Test
    public void testMapEntityToDto(){

        Customer customer = new Customer();
        customer.setName("Dave");
        customer.setId(101L);

        OrderItem orderItem = new OrderItem();
        orderItem.setName("iPhone");
        orderItem.setQuantity(2L);
        customer.setOrderItems(Collections.singleton(orderItem));

        CustomerDto customerdto = CustomerMapper.MAPPER.fromCustomer(customer);

        System.out.println(customerdto.toString());
        assertThat(customerdto.id).isEqualTo(101L);
        assertThat(customerdto.customerName).isEqualTo("Dave");
        assertThat(customerdto.orders).extracting("name","quantity").containsExactly(tuple("iPhone", 2L));

    }
}
