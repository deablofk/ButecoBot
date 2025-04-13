package dev.cwby.butecobot.api.users.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.cwby.butecobot.api.users.domain.User;
import dev.cwby.butecobot.users.dto.UserRequest;
import dev.cwby.butecobot.users.dto.UserResponse;

/**
 * UserMapper
 */
@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "isAdmin", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	@Mapping(target = "totalCoins", ignore = true)
	@Mapping(target = "canReceiveDailyCoins", ignore = true)
	User toEntity(UserRequest requestDto);

	UserResponse toResponse(User entity);

	List<UserResponse> toResponses(List<User> entities);

}
