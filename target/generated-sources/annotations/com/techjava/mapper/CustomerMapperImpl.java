package com.techjava.mapper;

import com.techjava.dto.Customer;
import com.techjava.dto.CustomerDto;
import com.techjava.dto.OrderItem;
import com.techjava.dto.OrderItemDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-09T16:23:42+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerDto.customerName );
        customer.setOrderItems( orderItemDtoListToOrderItemCollection( customerDto.orders ) );
        customer.setId( customerDto.id );

        return customer;
    }

    @Override
    public CustomerDto fromCustomer(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.orders = orderItemCollectionToOrderItemDtoList( customer.getOrderItems() );
        customerDto.customerName = customer.getName();
        customerDto.id = customer.getId();

        return customerDto;
    }

    protected OrderItem orderItemDtoToOrderItem(OrderItemDto orderItemDto) {
        if ( orderItemDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setName( orderItemDto.name );
        orderItem.setQuantity( orderItemDto.quantity );

        return orderItem;
    }

    protected Collection<OrderItem> orderItemDtoListToOrderItemCollection(List<OrderItemDto> list) {
        if ( list == null ) {
            return null;
        }

        Collection<OrderItem> collection = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemDto orderItemDto : list ) {
            collection.add( orderItemDtoToOrderItem( orderItemDto ) );
        }

        return collection;
    }

    protected OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.name = orderItem.getName();
        orderItemDto.quantity = orderItem.getQuantity();

        return orderItemDto;
    }

    protected List<OrderItemDto> orderItemCollectionToOrderItemDtoList(Collection<OrderItem> collection) {
        if ( collection == null ) {
            return null;
        }

        List<OrderItemDto> list = new ArrayList<OrderItemDto>( collection.size() );
        for ( OrderItem orderItem : collection ) {
            list.add( orderItemToOrderItemDto( orderItem ) );
        }

        return list;
    }
}
