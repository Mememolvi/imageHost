package com.image;

import com.image.dto.ImageDTO;
import com.image.repository.ImageRepository;
import com.image.service.ImageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageHostApplication implements CommandLineRunner {
	private static final Log LOGGER = LogFactory.getLog(ImageHostApplication.class);
	@Autowired
	ImageService imageService;

//	@Autowired
//	Environment environment;
	public static void main(String[] args) {

		SpringApplication.run(ImageHostApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(imageService.getImage(1));
		ImageDTO imageDTO = imageService.getImage(1);
		imageService.addImage(imageDTO);

	}

}
