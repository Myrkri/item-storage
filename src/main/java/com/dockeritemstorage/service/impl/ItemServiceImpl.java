package com.dockeritemstorage.service.impl;

import com.dockeritemstorage.dto.ItemDTO;
import com.dockeritemstorage.mapper.ItemMapper;
import com.dockeritemstorage.model.ItemEntity;
import com.dockeritemstorage.repository.ItemRepository;
import com.dockeritemstorage.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public ItemDTO saveItem(ItemDTO item) {
        ItemEntity itemEntity = ItemMapper.ITEM_MAPPER.toEntity(item);
        return ItemMapper.ITEM_MAPPER.toDto(itemRepository.save(itemEntity));
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> items = itemRepository.findAll();
        return ItemMapper.ITEM_MAPPER.toDto(items);
    }

    @Override
    public ItemDTO getItemById(Long id) {
        ItemEntity item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        return ItemMapper.ITEM_MAPPER.toDto(item);
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDetails) {
        ItemEntity item = itemRepository.findById(itemDetails.getId())
                .orElseThrow(() -> new RuntimeException("Item not found"));
        ItemEntity updatedItem = ItemMapper.ITEM_MAPPER.modifyItem(item, itemDetails);
        return ItemMapper.ITEM_MAPPER.toDto(itemRepository.save(updatedItem));
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
