package com.image.service;

import com.image.dto.ImageDTO;
import com.image.entity.ImageEntity;
import com.image.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
    public List<ImageDTO> findAll(int pageNumber) throws Exception {
        Pageable pageWithNumber = PageRequest.of(pageNumber, 2);
        Page<ImageEntity> imageEntityPage = imageRepository.findAll(pageWithNumber);
        List<ImageEntity> entityList = imageEntityPage.getContent();
        List<ImageDTO> imageDTOList = new ArrayList<>();
        for(ImageEntity imageEntity : entityList) {
            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setPicByte(imageEntity.getPicByte());
            imageDTOList.add(imageDTO);
        }
        return imageDTOList;
    }

    @Override
    public int addImage(ImageDTO imageDTO) throws Exception {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setPicByte(imageDTO.getPicByte());
        imageRepository.save(imageEntity);
        return imageEntity.getImage_id();

    }
}
