package dev.cwby.butecobot.api.events.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.cwby.butecobot.api.events.domain.EventChoice;
import dev.cwby.butecobot.events.dto.EventChoiceRequest;
import dev.cwby.butecobot.events.dto.EventChoiceResponse;

/**
 * EventChoiceMapper
 */
@Mapper
public interface EventChoiceMapper {
	EventChoiceMapper INSTANCE = Mappers.getMapper(EventChoiceMapper.class);

	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	EventChoice toEntity(EventChoiceRequest dto);

	EventChoiceResponse toResponse(EventChoice entity);

	List<EventChoiceResponse> toResponses(List<EventChoice> entities);

}
