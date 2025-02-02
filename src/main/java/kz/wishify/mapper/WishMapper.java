package kz.wishify.mapper;

import kz.wishify.dto.WishDto;
import kz.wishify.entity.WishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface WishMapper {

    WishDto toDto(WishEntity wishEntity);
    WishEntity toEntity(WishDto wishDto);

    @Mapping(target = "id", ignore = true)
    WishEntity updateEntity(@MappingTarget WishEntity wishEntity, WishDto wishDto);

    default List<WishDto> toListDto(List<WishEntity> wishEntities) {
        return wishEntities
                .stream()
                .map(this::toDto)
                .toList();
    }
}
