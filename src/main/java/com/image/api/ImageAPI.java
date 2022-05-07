package com.image.api;

import com.image.dto.ImageDTO;
import com.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/imagehost")
public class ImageAPI {
    @Autowired
    private ImageService imageService;

    @GetMapping(value = "/images/byte/{id}")
    public ResponseEntity<ImageDTO> getImageAsByte(@PathVariable Integer id) throws Exception {
        ImageDTO imageDTO = imageService.getImage(id);
        return new ResponseEntity<>(imageDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/images/{id}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) throws Exception {
        ImageDTO imageDTO = imageService.getImage(id);
        return new ResponseEntity<>(imageDTO.getPicByte(), HttpStatus.OK);
    }

    @GetMapping(value = "/images/byte/all/{pageNumber}")
    public ResponseEntity<List<ImageDTO>> getAllImagesAsByte(@PathVariable Integer pageNumber) throws Exception {
        List<ImageDTO> imageDTOList = imageService.findAll(pageNumber);
        return new ResponseEntity<>(imageDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "/images")
    public ResponseEntity<String> addImage(@RequestParam("imageFile") MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setPicByte(bytes);
        Integer id = imageService.addImage(imageDTO);
        return new ResponseEntity<>("SUCCESS :" + id, HttpStatus.CREATED);
    }

}
