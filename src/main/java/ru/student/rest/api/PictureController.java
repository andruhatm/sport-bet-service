package ru.student.rest.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.student.data.dto.PictureGetDto;
import ru.student.rest.service.PictureService;

import java.io.IOException;

@RestController
@RequestMapping(path = "/picture/")
public class PictureController {

  private final PictureService pictureService;

  public PictureController(PictureService pictureService) {
    this.pictureService = pictureService;
  }

  @PostMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
  public PictureGetDto uploadPicture(@RequestParam("file") MultipartFile multipartFile) throws IOException {
    return pictureService.create(multipartFile);
  }
}
