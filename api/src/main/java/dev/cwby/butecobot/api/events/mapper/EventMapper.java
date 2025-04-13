package dev.cwby.butecobot.api.events.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.cwby.butecobot.api.events.domain.Event;
import dev.cwby.butecobot.events.dto.EventRequest;
import dev.cwby.butecobot.events.dto.EventResponse;

/**
 * EventMapper
 */
@Mapper
public interface EventMapper {
	EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	Event toEntity(EventRequest dto);

	EventResponse toResponse(Event entity);

	List<EventResponse> toResponses(List<Event> entities);

}
