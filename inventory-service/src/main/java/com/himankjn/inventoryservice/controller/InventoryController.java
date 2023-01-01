package com.himankjn.inventoryservice.controller;

import com.himankjn.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam("skuCodes") List<String> skuCodes, @RequestParam("quantities") List<String> orderQuantities){
        System.out.println(skuCodes);
        System.out.println(orderQuantities);
        return inventoryService.isInStock(skuCodes,orderQuantities);
    }
}
