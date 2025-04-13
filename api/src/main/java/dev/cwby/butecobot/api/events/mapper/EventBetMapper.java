package dev.cwby.butecobot.api.events.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.cwby.butecobot.api.events.domain.EventBet;
import dev.cwby.butecobot.events.dto.EventBetRequest;
import dev.cwby.butecobot.events.dto.EventBetResponse;

/**
 * EventBetMapper
 */
@Mapper
public interface EventBetMapper {
	EventBetMapper INSTANCE = Mappers.getMapper(EventBetMapper.class);

	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	EventBet toEntity(EventBetRequest dto);

	EventBetResponse toResponse(EventBet entity);

	List<EventBetResponse> toResponses(List<EventBet> entities);

}
