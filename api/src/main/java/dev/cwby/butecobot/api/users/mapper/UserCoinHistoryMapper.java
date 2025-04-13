package dev.cwby.butecobot.api.users.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.cwby.butecobot.api.users.domain.UserCoinHistory;
import dev.cwby.butecobot.users.dto.UserCoinHistoryRequest;
import dev.cwby.butecobot.users.dto.UserCoinHistoryResponse;

/**
 * UserCoinHistoryMapper
 */
@Mapper
public interface UserCoinHistoryMapper {
	UserCoinHistoryMapper INSTANCE = Mappers.getMapper(UserCoinHistoryMapper.class);

	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	@Mapping(target = "id", ignore = true)
	UserCoinHistory toEntity(UserCoinHistoryRequest requestDto);

	UserCoinHistoryResponse toResponse(UserCoinHistory entity);

	List<UserCoinHistoryResponse> toResponses(List<UserCoinHistory> entities);

}
