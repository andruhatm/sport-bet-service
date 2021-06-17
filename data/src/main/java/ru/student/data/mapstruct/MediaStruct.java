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
    @Mapping(target="user", ignore = true),
  })
  public abstract MediaDTO toMediaDTO(Media media);
  public abstract List<MediaDTO> toMediaDTOs(List<Media> media);
  @Mappings({
    @Mapping(target="user", ignore = true),
  })
  public abstract Media toMedia(MediaDTO mediaDTO) throws EntityNotFoundException;

  @Mappings({
    @Mapping(target="user", ignore = true),
  })
  public abstract void updateMediaFromDto(MediaDTO mediaDTO, @MappingTarget Media media);
}
