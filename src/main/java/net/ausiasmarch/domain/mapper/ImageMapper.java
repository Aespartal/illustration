package net.ausiasmarch.domain.mapper;

import net.ausiasmarch.domain.Image;
import net.ausiasmarch.service.dto.ImageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper extends EntityMapper<ImageDTO, Image> {
    ImageDTO toDto(Image image);

    Image toEntity(ImageDTO imageDTO);

    default Image fromId(Integer id) {
        if (id == null) {
            return null;
        }
        Image image = new Image();
        image.setId(id);
        return image;
    }
}
