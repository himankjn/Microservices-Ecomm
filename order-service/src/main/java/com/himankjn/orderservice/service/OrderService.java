package com.himankjn.orderservice.service;

import com.himankjn.orderservice.dao.OrderDao;
import com.himankjn.orderservice.model.Order;
import com.himankjn.orderservice.model.OrderLineItems;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    public void placeOrder(Order order){
        // call inventory service to check if products in order are in stock
        List<OrderLineItems> items= order.getOrderLineItemsList();
        List<String>codes=new ArrayList<String>();
        List<Integer>quantities=new ArrayList<Integer>();
        for (OrderLineItems item: items){
            quantities.add(item.getQuantity());
            codes.add(item.getSkuCode());
        }

        boolean flag=true;

        //sending comma separated values to the inventory-service api to test for stock
        String codeString=String.join(",",codes);
        String quantitiesString=String.join(",",quantities.stream().map(Object::toString).collect(Collectors.toList()));
        String checkUrl=env.getProperty("inventory-service.url")+"?skuCodes="+codeString+"&quantities="+quantitiesString;
        System.out.println(checkUrl);

        ResponseEntity<Boolean>responseEntity = restTemplate.getForEntity(checkUrl,Boolean.class);
        boolean x= Boolean.TRUE.equals(responseEntity.getBody());
        if(!x){
            flag=false;
        }

        if(flag) {
            orderDao.save(order);
        }
        else{
            throw new IllegalArgumentException("Product Not in sock! Please try again later.");
        }
    }
}
