package ru.student.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.student.data.dto.PictureGetDto;
import ru.student.data.mapstruct.PictureMapper;
import ru.student.data.model.Picture;
import ru.student.data.repo.PictureRepo;

import java.io.IOException;

/**
 * Имплементация сервиса работы с картинками
 */
@Service
public class PictureServiceImpl implements PictureService {

    private final PictureMapper pictureMapper;
    private final PictureRepo pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepo pictureRepository,
															PictureMapper pictureMapper) {
        this.pictureRepository = pictureRepository;
        this.pictureMapper = pictureMapper;
    }

    @Override
    public PictureGetDto create(MultipartFile picture) throws IOException {
        String name = StringUtils.cleanPath(picture.getOriginalFilename());
        Picture pic = new Picture();
        pic.setName(name);
        pic.setType(picture.getContentType());
        pic.setData(picture.getBytes());

        return pictureMapper.toGetDto(pictureRepository.save(pic));
    }

    @Override
    public PictureGetDto getPicture(int id) {
        return pictureMapper.toGetDto(pictureRepository.findById(id).get());
    }

    @Override
    public PictureGetDto findByName(String name) {
        return pictureMapper.toGetDto(pictureRepository.findByName(name));
    }
}
