package com.image;

import com.image.service.ImageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageHostApplication {
    private static final Log LOGGER = LogFactory.getLog(ImageHostApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ImageHostApplication.class, args);
    }

}
