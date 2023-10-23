package com.kavita.adaptavist.kafkawordcountdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {

    boolean hasCsvFormat(MultipartFile file);

}
