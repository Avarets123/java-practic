package com.example.finalproject.modules.films.controller;

import com.example.finalproject.modules.auth.config.details.CustomUserDetails;
import com.example.finalproject.modules.films.dto.FilmCreateDto;
import com.example.finalproject.modules.films.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public String filmsPage(Model model, Authentication authentication, @AuthenticationPrincipal CustomUserDetails userDetails) {
        model.addAttribute("film", new FilmCreateDto());
        model.addAttribute("films", filmService.getAllFilms());
        if (authentication != null) {
            model.addAttribute("role", userDetails.getUser().getRole().toString());
        } else {
            model.addAttribute("role", "");
        }

        return "cinema/films_page";
    }

    @GetMapping("/{id}")
    public String filmPage(
            @PathVariable("id") Long filmId,
            @AuthenticationPrincipal CustomUserDetails userDetails,
            Model model) {
        model.addAttribute("film", filmService.getFilmById(filmId));
        model.addAttribute("tickets", filmService.findAllTicketsByFilm_Id(filmId));
        model.addAttribute("auth", userDetails.getUser());
        return "cinema/film_page";
    }

    @PostMapping
    public String addFilm(FilmCreateDto film) {
        filmService.saveFilm(film);
        return "redirect:/films";
    }

    @PostMapping("/{id}/buyTicket")
    public String addTicket(@PathVariable("id") Long filmId, @RequestParam("place") Integer place,
                            @AuthenticationPrincipal CustomUserDetails userDetails) {
        filmService.addTicket(filmId, place, userDetails.getUser().getId());
        return "redirect:/films/" + filmId;
    }

    @GetMapping("/{id}/delete")
    public String deleteFilm(@PathVariable("id") Long filmId) {
        filmService.deleteFilm(filmId);
        return "redirect:/films";
    }

    @PostMapping("/{id}/update")
    public String updateFilm(@PathVariable("id") Long filmId, FilmCreateDto film) {

        filmService.updateFilmDto(filmId, film);
        return "redirect:/films";
    }

    @PostMapping("/tickets/{id}")
    public String updateTicket(@PathVariable("id") Long ticketId, Integer place) {
        filmService.updateTicket(ticketId, place);
        return "redirect:/films";
    }

}
