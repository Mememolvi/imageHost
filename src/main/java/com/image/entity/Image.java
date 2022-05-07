package com.image.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer image_id;
    @Column(name = "image", length = 1000)
    private byte[] picByte;

    public Image()
    {}

    public Image(Integer image_id, byte[] picByte) {
        this.image_id = image_id;
        this.picByte = picByte;
    }

    public Integer getImage_id() {
        return image_id;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(image_id, image.image_id) && Arrays.equals(picByte, image.picByte);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(image_id);
        result = 31 * result + Arrays.hashCode(picByte);
        return result;
    }

    @Override
    public String toString() {
        return "Image{" +
                "image_id=" + image_id +
                ", picByte=" + Arrays.toString(picByte) +
                '}';
    }
}