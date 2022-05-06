package com.image.dto;

import java.util.Arrays;

public class ImageDTO {
    private byte[] picByte;

    @Override
    public String toString() {
        return "ImageDTO{" +
                "picByte=" + Arrays.toString(picByte) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageDTO imageDTO = (ImageDTO) o;
        return Arrays.equals(picByte, imageDTO.picByte);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(picByte);
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
