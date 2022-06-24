package com.extrieve.anime.controller;

import com.extrieve.anime.entity.Anime;
import com.extrieve.anime.exception.ResourceNotFoundException;
import com.extrieve.anime.service.AnimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/")
public class AnimeController {

    @Autowired
    private AnimeServiceImpl animeService;

    @GetMapping("/all")
    public ResponseEntity<Collection<Anime>> getAllAnime(){
        Collection<Anime> allAnime = animeService.getAll();
        return ResponseEntity.ok(allAnime);
    }

    @GetMapping("/anime/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable String id){
        try {
        Anime anime = animeService.findByAnimeId(id);
        return ResponseEntity.ok(anime);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Anime with id:" + id + " not found.");
        }

    }
}
