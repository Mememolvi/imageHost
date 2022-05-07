package com.image.repository;

import com.image.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ImageRepository extends PagingAndSortingRepository<Image, Integer> {
    @Query("SELECT I.image_id FROM Image I")
    Page<Integer> findAllImageId(Pageable pageable);
}
