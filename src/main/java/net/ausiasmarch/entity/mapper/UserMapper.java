package net.ausiasmarch.entity.mapper;

import net.ausiasmarch.entity.UserEntity;
import net.ausiasmarch.entity.dto.UserDTO;
import net.ausiasmarch.entity.interfaces.GenericEntityInterface;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    UserDTO toDto(UserEntity userEntity);

    @Mapping(source = "userId", target = "id")
    UserEntity toEntity(UserDTO userDTO);

    UserDTO toGenericDTO(GenericEntityInterface genericEntityInterface);
}
