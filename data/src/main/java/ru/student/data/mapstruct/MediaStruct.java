package ru.student.data.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import ru.student.data.dto.MediaDTO;
import ru.student.data.model.Media;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Mapper
public abstract class MediaStruct {

  @Mappings({
    @Mapping(target = "user", ignore = true),
    @Mapping(target = "categories", source = "media.categoriesFile")
  })
  public abstract MediaDTO toMediaDTO(Media media);

  public abstract List<MediaDTO> toMediaDTOs(List<Media> media);

  @Mappings({
    @Mapping(target = "user", ignore = true),
    @Mapping(target = "categoriesFile", source = "categories"),
  })
  public abstract Media toMedia(MediaDTO mediaDTO) throws EntityNotFoundException;

  @Mappings({
    @Mapping(target = "user", ignore = true),
    @Mapping(target = "categoriesFile", source = "categories")
  })
  public abstract void updateMediaFromDto(MediaDTO mediaDTO, @MappingTarget Media media);
}
