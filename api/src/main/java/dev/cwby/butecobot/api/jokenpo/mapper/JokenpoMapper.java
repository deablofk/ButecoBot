package dev.cwby.butecobot.api.jokenpo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.cwby.butecobot.api.jokenpo.domain.Jokenpo;
import dev.cwby.butecobot.users.dto.JokenpoRequest;
import dev.cwby.butecobot.users.dto.JokenpoResponse;

/**
 * JokenpoMapper
 */
@Mapper
public interface JokenpoMapper {

	JokenpoMapper INSTANCE = Mappers.getMapper(JokenpoMapper.class);

	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	Jokenpo toEntity(JokenpoRequest dto);

	JokenpoResponse toResponse(Jokenpo entity);

	List<JokenpoResponse> toResponses(List<Jokenpo> entities);

}
