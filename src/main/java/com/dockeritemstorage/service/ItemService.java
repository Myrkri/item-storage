package com.dockeritemstorage.service;

import com.dockeritemstorage.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    ItemDTO saveItem(ItemDTO item);
    List<ItemDTO> getAllItems();
    ItemDTO getItemById(Long id);
    ItemDTO updateItem(ItemDTO itemDetails);
    void deleteItem(Long id);

}
