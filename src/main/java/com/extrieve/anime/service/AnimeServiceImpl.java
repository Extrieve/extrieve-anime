package com.extrieve.anime.service;

import com.extrieve.anime.entity.Anime;
import com.extrieve.anime.repository.AnimeRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AnimeServiceImpl implements AnimeService {

    // TODO: Change return types to ResponseEntity

    @Autowired
    AnimeRepository animeRepo;

    @Autowired
    Logger logger;


    public ResponseEntity<Collection<Anime>> getAll() {
        logger.info("Fetching all anime");
        return ResponseEntity.ok(animeRepo.findAll());
    }


    public ResponseEntity<Anime> findByAnimeId(Long id) {
        logger.info("Fetching anime with ID: " + id);
        return ResponseEntity.ok().body(animeRepo.findByAnimeId(id));
    }


    public ResponseEntity<Collection<Anime>> findByAnimeTitleIgnoreCase(String name) {
        logger.info("Fetching anime with name " + name);
        return ResponseEntity.ok(animeRepo.findByAnimeTitleIgnoreCase(name));
    }


    public ResponseEntity<Collection<Anime>> findAnimeByName(String name) {
        logger.info("Fetching anime with name " + name);
        return ResponseEntity.ok(animeRepo.findByAnimeTitleContaining(name));
    }


    public ResponseEntity<Anime> saveAnime(Anime anime) {
        logger.info("Saving anime with title: " + anime.getAnimeTitle());
        return ResponseEntity.ok().body(animeRepo.save(anime));
    }
}
