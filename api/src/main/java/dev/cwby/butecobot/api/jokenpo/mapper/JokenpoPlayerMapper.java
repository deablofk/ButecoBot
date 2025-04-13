package dev.cwby.butecobot.api.jokenpo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.cwby.butecobot.api.jokenpo.domain.JokenpoPlayer;
import dev.cwby.butecobot.users.dto.JokenpoPlayerRequest;
import dev.cwby.butecobot.users.dto.JokenpoPlayerResponse;

/**
 * JokenpoPlayermapper
 */
@Mapper
public interface JokenpoPlayerMapper {

	JokenpoPlayerMapper INSTANCE = Mappers.getMapper(JokenpoPlayerMapper.class);

	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	JokenpoPlayer toEntity(JokenpoPlayerRequest dto);

	JokenpoPlayerResponse toResponse(JokenpoPlayer entity);

	List<JokenpoPlayerResponse> toResponses(List<JokenpoPlayer> entities);

}
