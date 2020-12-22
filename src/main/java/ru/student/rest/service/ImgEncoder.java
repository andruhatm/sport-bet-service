package ru.student.rest.service;

import java.util.Base64;

public class ImgEncoder {
  public String encode(byte[] data){
    return Base64.getMimeEncoder().encodeToString(data);
  }
}
