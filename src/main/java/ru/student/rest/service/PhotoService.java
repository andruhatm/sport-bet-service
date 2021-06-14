package ru.student.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.student.data.model.Photo;
import ru.student.data.repo.PhotoRepo;

import java.io.IOException;


/**
 * Сервис для фото профиля.
 *
 * @author andruha.tm
 */
@Service
public class PhotoService {

  PhotoRepo photoRepo;

  @Autowired
  public PhotoService(PhotoRepo photoRepo) {
    this.photoRepo = photoRepo;
  }

  public Photo store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Photo photo = new Photo(fileName,file.getContentType(),file.getBytes());
    return photoRepo.save(photo);
  }

  public Photo getPhoto(Integer id){
    return photoRepo.findById(id).get();
  }
}
