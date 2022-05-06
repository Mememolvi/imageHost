package com.image.service;

import com.image.dto.ImageDTO;

public interface ImageService {
    int addImage(ImageDTO imageDTO) throws Exception;
    ImageDTO getImage(int id) throws Exception;
}
