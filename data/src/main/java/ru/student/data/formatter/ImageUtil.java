package ru.student.data.formatter;

import java.util.Base64;

/**
 * Работа с картинкой
 */
public class ImageUtil {

    /**
     * Преобразование картинки.
     *
     * @param byteData массив байт картинки
     * @return строка
     */
    public String getImgData(byte[] byteData) {
        return Base64.getMimeEncoder().encodeToString(byteData);
    }
}
