package com.himankjn.inventoryservice.service;

import com.himankjn.inventoryservice.dao.InventoryDao;
import com.himankjn.inventoryservice.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryDao inventoryDao;
    @Transactional(readOnly = true)
    public boolean isInStock(List<String> skuCodes,List<String> orderQuantities){
        List<Inventory> inventories=inventoryDao.findBySkuCodeIn(skuCodes);
        boolean flag=true;

        for(int i=0;i<inventories.size();i++){
            if(inventories.get(i).getQuantity()<Integer.valueOf(orderQuantities.get(i))){
                flag=false;
                break;
            }
        }

        return flag;
    }
}
