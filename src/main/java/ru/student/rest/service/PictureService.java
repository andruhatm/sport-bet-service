package ru.student.rest.service;

import org.springframework.web.multipart.MultipartFile;
import ru.student.data.dto.PictureGetDto;

import java.io.IOException;

public interface PictureService {

    /**
     * Создать картинку.
     *
     * @param picture данные для создания картинки в базе данных
     * @return созданная картинка
     * @throws IOException исключение при создании картинки
     */
    PictureGetDto create(MultipartFile picture) throws IOException;

    /**
     * Вернуть картинку по ее ID.
     *
     * @param id ID картинки
     * @return найденная картинка
     */
    PictureGetDto getPicture(int id);

    /**
     * Вернуть картинку по ее названию.
     *
     * @param name название картинки
     * @return найденная картинка
     */
    PictureGetDto findByName(String name);
}
