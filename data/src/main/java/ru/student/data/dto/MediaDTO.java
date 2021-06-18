package ru.student.data.dto;

import lombok.Data;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MediaDTO {
    private Integer mediaID;
    private String fileName;
    private Integer width;
    private Integer height;
    private String securityUrl;
    private UserDto user;
    private LocalDateTime dateAdded;
}
