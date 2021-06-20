package ru.student.data.mapstruct;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.student.data.dto.PictureCreateDto;
import ru.student.data.dto.PictureGetDto;
import ru.student.data.model.Picture;

import java.util.List;

/**
 * Маппер для картинок
 */
@Mapper(componentModel = "spring")
public interface PictureMapper {

    public PictureGetDto toGetDto(Picture entity);

    public Picture fromGetDto(PictureGetDto getDto);

    public List<PictureGetDto> toGetDto(Iterable<Picture> entities);

    @Mapping(target = "id", ignore = true)
    public Picture fromCreateDto(PictureCreateDto createDto);
}
