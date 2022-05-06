package com.image.service;

import com.image.dto.ImageDTO;
import com.image.entity.ImageEntity;
import com.image.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service(value = "imageService")
@Transactional
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ImageDTO getImage(int id) throws Exception {
        Optional<ImageEntity> imageEntityOP = imageRepository.findById(id);
        ImageEntity imageEntity = imageEntityOP.get();
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setPicByte(imageEntity.getPicByte());
        return imageDTO;
    }

    @Override
    public int addImage(ImageDTO imageDTO) throws Exception {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setPicByte(imageDTO.getPicByte());
        imageRepository.save(imageEntity);
        return imageEntity.getImage_id();

    }
}
