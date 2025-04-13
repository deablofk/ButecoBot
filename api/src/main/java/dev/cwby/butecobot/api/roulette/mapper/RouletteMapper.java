package dev.cwby.butecobot.api.roulette.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.cwby.butecobot.api.roulette.domain.Roulette;
import dev.cwby.butecobot.users.dto.RouletteRequest;
import dev.cwby.butecobot.users.dto.RouletteResponse;

/**
 * RouletteMapper
 */
@Mapper
public interface RouletteMapper {

	RouletteMapper INSTANCE = Mappers.getMapper(RouletteMapper.class);

	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	Roulette toEntity(RouletteRequest dto);

	RouletteResponse toResponse(Roulette entity);

	List<RouletteResponse> toResponses(List<Roulette> entities);

}
