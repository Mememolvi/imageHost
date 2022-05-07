package com.image.repository;

import com.image.entity.ImageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ImageRepository extends PagingAndSortingRepository<ImageEntity, Integer> {
}
