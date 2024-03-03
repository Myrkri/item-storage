package com.dockeritemstorage.mapper;

import com.dockeritemstorage.dto.ItemDTO;
import com.dockeritemstorage.model.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemMapper ITEM_MAPPER = Mappers.getMapper(ItemMapper.class);

    ItemEntity toEntity(ItemDTO dto);
    ItemDTO toDto(ItemEntity entity);
    List<ItemDTO> toDto(List<ItemEntity> entities);
    ItemEntity modifyItem(@MappingTarget ItemEntity target, ItemDTO from);

}
