package com.extrieve.anime.service;

import com.extrieve.anime.entity.Anime;
import com.extrieve.anime.repository.AnimeRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
//@Slf4j
public class AnimeServiceImpl implements AnimeService {

    // TODO: Change return types to ResponseEntity

    @Autowired
    AnimeRepository animeRepo;

//    @Autowired
    private final Logger logger = LoggerFactory.getLogger(AnimeServiceImpl.class);


    public ResponseEntity<Collection<Anime>> getAll() {
        logger.info("Fetching all anime");
        return ResponseEntity.ok(animeRepo.findAll());
    }


    public ResponseEntity<Anime> findByAnimeId(Long id) {
        logger.info("Fetching anime with ID: " + id);
        try {
            return ResponseEntity.ok().body(animeRepo.findByAnimeId(id));
        } catch (RuntimeException e) {
            throw new RuntimeException("Anime with id:" + id + " not found.");
        }
    }


    public ResponseEntity<Collection<Anime>> findByAnimeTitleIgnoreCase(String name) {
        logger.info("Fetching anime with name " + name);

        if (name == null) {
            throw new RuntimeException("Anime name cannot be null");
        }
        Collection<Anime> payload = animeRepo.findByAnimeTitleIgnoreCase(name);

        if (payload.size() == 0) {
            logger.warn("Anime with name " + name + " not found.");
        }

        return ResponseEntity.ok(payload);
    }


    public ResponseEntity<Collection<Anime>> findAnimeByName(String name) {
        logger.info("Fetching anime with name " + name);

        if (name == null) {
            throw new RuntimeException("Anime name cannot be null");
        }

        Collection<Anime> payload = animeRepo.findByAnimeTitleContaining(name);

        if (payload.size() == 0) {
            logger.warn("Anime with name " + name + " not found.");
        }

        return ResponseEntity.ok(payload);
    }


    public ResponseEntity<Anime> saveAnime(Anime anime) {
        logger.info("Saving anime with title: " + anime.getAnimeTitle());
        return ResponseEntity.ok().body(animeRepo.save(anime));
    }
}
