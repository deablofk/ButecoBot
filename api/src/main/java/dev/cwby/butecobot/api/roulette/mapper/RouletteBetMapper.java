package dev.cwby.butecobot.api.roulette.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dev.cwby.butecobot.api.roulette.domain.RouletteBet;
import dev.cwby.butecobot.roulette.dto.RouletteBetRequest;
import dev.cwby.butecobot.roulette.dto.RouletteBetResponse;

/**
 * RouletteBetMapper
 */
@Mapper
public interface RouletteBetMapper {

	RouletteBetMapper INSTANCE = Mappers.getMapper(RouletteBetMapper.class);

	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	RouletteBet toEntity(RouletteBetRequest dto);

	RouletteBetResponse toResponse(RouletteBet entity);

	List<RouletteBetResponse> toResponses(List<RouletteBet> entities);

}
