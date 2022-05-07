package com.image.service;

import com.image.dto.ImageDTO;
import com.image.entity.Image;
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
        Optional<Image> imageEntityOP = imageRepository.findById(id);
        Image image = imageEntityOP.get();
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setPicByte(image.getPicByte());
        return imageDTO;
    }

    @Override
    public List<ImageDTO> findAll(int pageNumber) throws Exception {
        Pageable pageWithNumber = PageRequest.of(pageNumber, 2);
        Page<Image> imageEntityPage = imageRepository.findAll(pageWithNumber);
        List<Image> entityList = imageEntityPage.getContent();
        List<ImageDTO> imageDTOList = new ArrayList<>();
        for (Image image : entityList) {
            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setPicByte(image.getPicByte());
            imageDTOList.add(imageDTO);
        }
        return imageDTOList;
    }

    @Override
    public int addImage(ImageDTO imageDTO) throws Exception {
        Image image = new Image();
        image.setPicByte(imageDTO.getPicByte());
        imageRepository.save(image);
        return image.getImage_id();

    }

    @Override
    public List<Integer> findAllImageId(int pageNumber) throws Exception {
        Pageable pageWithNumber = PageRequest.of(pageNumber, 3);
        Page<Integer> imageEntityPage = imageRepository.findAllImageId(pageWithNumber);
        return imageEntityPage.getContent();
    }
}
