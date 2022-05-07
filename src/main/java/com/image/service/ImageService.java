package com.image.service;

import com.image.dto.ImageDTO;

import java.util.List;

public interface ImageService {
    int addImage(ImageDTO imageDTO) throws Exception;

    ImageDTO getImage(int pageNumber) throws Exception;

    List<ImageDTO> findAll(int pageNumber) throws Exception;
}
