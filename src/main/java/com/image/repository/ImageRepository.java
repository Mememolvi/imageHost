package com.image.repository;

import org.springframework.data.repository.CrudRepository;
import com.image.entity.ImageEntity;


public interface ImageRepository extends CrudRepository<ImageEntity, Integer>{
}
