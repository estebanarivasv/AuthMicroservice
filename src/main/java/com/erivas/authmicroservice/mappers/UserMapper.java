package com.erivas.authmicroservice.mappers;
import com.erivas.authmicroservice.dtos.UserDto;
import com.erivas.authmicroservice.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface UserMapper {

    // Mapper instance
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Generates toEntity and toDto methods in target package
    UserModel toEntity(UserDto userDto);

    UserDto toDto(UserModel userModel);

}
