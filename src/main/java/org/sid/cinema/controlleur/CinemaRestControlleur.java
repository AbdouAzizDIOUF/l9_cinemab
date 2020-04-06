package org.sid.cinema.controlleur;

import org.sid.cinema.Repository.FilmRepository;
import org.sid.cinema.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CinemaRestControlleur {
    private final FilmRepository filmRepository;


    public CinemaRestControlleur(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/listeFilms")
    public List<Film> films(){
        return filmRepository.findAll();
    }
}
