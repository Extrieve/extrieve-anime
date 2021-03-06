package com.extrieve.anime.controller;

import com.extrieve.anime.entity.Anime;
import com.extrieve.anime.exception.ResourceNotFoundException;
import com.extrieve.anime.service.AnimeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Slf4j
@RequestMapping("/api/v1/")
// @CrossOrigin(origins = "http://localhost:4200")
public class AnimeController {

    @Autowired
    private AnimeServiceImpl animeService;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/anime")
    public ResponseEntity<Collection<Anime>> getAllAnime(){
        log.info("Getting all anime");
        return animeService.getAll();
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/anime/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable Long id){
        log.info("Fetching anime by ID");
        try {
            return this.animeService.findByAnimeId(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Anime with id:" + id + " not found.");
        }

    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/save")
    public ResponseEntity<Anime> saveAnime(@RequestBody Anime anime){
        log.info("Saving anime with title: " + anime.getAnimeTitle());
        return animeService.saveAnime(anime);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/search/{animeName}")
    public ResponseEntity<Collection<Anime>> getAnimeByName(@PathVariable String animeName){
        log.info("Fetching anime with name: " + animeName);
        return animeService.findAnimeByName(animeName);
    }
}
