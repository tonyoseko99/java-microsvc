package com.developer.tonny.inventoryservice.service;

import com.developer.tonny.inventoryservice.model.InventoryCreateDto;
import com.developer.tonny.inventoryservice.model.InventoryResponse;

import java.util.List;

public interface InventoryService {

    InventoryResponse createInventory(InventoryCreateDto inventoryCreateDto);

    Boolean checkInventory(List<String> productCodes, List<Integer> productQuantities);

}
