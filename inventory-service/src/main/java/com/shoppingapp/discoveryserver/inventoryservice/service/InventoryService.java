package com.shoppingapp.discoveryserver.inventoryservice.service;

import com.shoppingapp.discoveryserver.inventoryservice.dto.InventoryResponse;
import com.shoppingapp.discoveryserver.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
//@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        //log.info("Checking Inventory");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }

//    @Transactional(readOnly = true)
//    public boolean isInStock(String skuCode) {
//        return inventoryRepository.findBySkuCode(skuCode).isPresent();
//    }
}