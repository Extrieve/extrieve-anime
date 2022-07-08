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

    Logger logger;


    public ResponseEntity<Collection<Anime>> getAll() {
        return ResponseEntity.ok(animeRepo.findAll());
    }


    public ResponseEntity<Anime> findByAnimeId(Long id) {
        return ResponseEntity.ok().body(animeRepo.findByAnimeId(id));
    }


    public Collection<Anime> findByAnimeTitleIgnoreCase(String name) {
        return animeRepo.findByAnimeTitleIgnoreCase(name);
    }


    public Collection<Anime> findAnimeByName(String name) {
        return animeRepo.findByAnimeTitle(name);
    }



    public Collection<Anime> getAnimeByAnimeNameAndAnimeType (String name, String type) {
        return null;
    }


    public Anime saveAnime(Anime anime) {
        return animeRepo.save(anime);
    }
}
