# Image Host

###

This is a spring based image host with a MySQL databse.

## Technologies Used

###

1. Spring
2. MySQL
3. Java
4. Spring Data
5. JPA

## mySQL script for the project contained in file mySqlScript

## API

## Get requests:

#### To return byte array representing image with ID = id

    `imagehost/images/byte/{id}`

#### To return the Image with ID = id

    `imagehost/images/{id}`

#### To return a list of byte arrays each representing a Image for the requested pageNumber. (pagesize = 3)

    `imagehost/images/byte/all/{pageNumber}`

#### To return a list of images for a particular pageNumber. (pagesize = 3)

    `imagehost/images/all/id/{pageNumber}`

## Post request:

#### Expects form-data as request body where imageFile key is mapped to value = image.

    `imagehost/images`
