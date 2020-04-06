package org.sid.cinema.controlleur;

import org.sid.cinema.Repository.FilmRepository;
import org.sid.cinema.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class CinemaRestControlleur {
    private final FilmRepository filmRepository;


    public CinemaRestControlleur(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping(path = "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public  byte[] getImage(@PathVariable("id") Long id) throws IOException {
        Film f = filmRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/imagesProjects/l9-project/film/"+f.getPhoto()+".jpg"));
    }

}
