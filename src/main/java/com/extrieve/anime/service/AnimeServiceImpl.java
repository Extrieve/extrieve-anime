package com.extrieve.anime.service;

import com.extrieve.anime.entity.Anime;
import com.extrieve.anime.repository.AnimeRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AnimeServiceImpl implements AnimeService {

    @Autowired
    AnimeRepository animeRepo;

    Logger logger;

    @Override
    public Collection<Anime> getAll() {
        return animeRepo.findAll();
    }

    @Override
    public Anime findByAnimeId(Long id) {
        return animeRepo.findByAnimeId(id);
    }

    @Override
    public Collection<Anime> findAnimeByName(String name) {
        return animeRepo.findByAnimeTitle(name);
    }

    @Override
    public Collection<Anime> getAnimeByNameIgnoreCase(String name) {
        return null;
    }


    @Override
    public Collection<Anime> getAnimeByAnimeNameAndAnimeType (String name, String type) {
        return null;
    }

    @Override
    public Anime saveAnime(Anime anime) {
        return animeRepo.save(anime);
    }
}
