package dev.cwby.butecobot.api.users.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.cwby.butecobot.api.users.domain.UserChangeHistory;
import dev.cwby.butecobot.users.dto.UserChangeHistoryRequest;
import dev.cwby.butecobot.users.dto.UserChangeHistoryResponse;

/**
 * UserChangeHistoryMapper
 */
@Mapper
public interface UserChangeHistoryMapper {

	UserChangeHistoryMapper INSTANCE = Mappers.getMapper(UserChangeHistoryMapper.class);

	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	UserChangeHistory toEntity(UserChangeHistoryRequest dto);

	UserChangeHistoryResponse toResponse(UserChangeHistory entity);

	List<UserChangeHistoryResponse> toResponses(List<UserChangeHistory> entities);

}
