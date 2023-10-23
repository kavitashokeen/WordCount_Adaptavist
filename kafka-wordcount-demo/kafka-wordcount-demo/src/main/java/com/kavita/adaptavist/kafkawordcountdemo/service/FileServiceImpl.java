package com.kavita.adaptavist.kafkawordcountdemo.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class FileServiceImpl implements FileService
{
    @Override
    public boolean hasCsvFormat(MultipartFile file) {
        String type = "text/csv";
        if(!type.equals(file.getContentType()))
        {
            return false;
        }
        return true;
    }

}
