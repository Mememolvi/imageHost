package com.image.api;

import com.image.dto.ImageDTO;
import com.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/imagehost")
public class ImageAPI {
    @Autowired
    private ImageService imageService;

    @GetMapping(value = "/images/{id}")
    public ResponseEntity<ImageDTO> getImage(@PathVariable Integer id) throws Exception {
        ImageDTO imageDTO = imageService.getImage(id);
        return new ResponseEntity<>(imageDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/images")
    public ResponseEntity<String> addImage(@RequestParam("imageFile") MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setPicByte(bytes);
        Integer id = imageService.addImage(imageDTO);
        return new ResponseEntity<>("SUCCESS :"+id, HttpStatus.CREATED);
    }

}
