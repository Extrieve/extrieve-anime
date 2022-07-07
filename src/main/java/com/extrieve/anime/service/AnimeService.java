package com.extrieve.anime.service;

import com.extrieve.anime.entity.Anime;

import java.util.Collection;

public interface AnimeService {

    public Collection<Anime> getAll();

    public Anime findByAnimeId(Long id);

    public Collection<Anime> findByAnimeTitleIgnoreCase(String name);

    public Collection<Anime> findAnimeByName(String name);

    public Collection<Anime> getAnimeByAnimeNameAndAnimeType (String name, String type);

    public Anime saveAnime(Anime anime);

}
