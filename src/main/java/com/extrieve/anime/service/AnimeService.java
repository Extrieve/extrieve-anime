package com.extrieve.anime.service;

import com.extrieve.anime.entity.Anime;

import java.util.Collection;

public interface AnimeService {

    public Collection<Anime> getAll();

    public Anime findByAnimeId(String id);

    public Collection<Anime> getAnimeByNameIgnoreCase(String name);

    public Collection<Anime> getAnimeByName(String name);

    public Collection<Anime> getAnimeByAnimeNameAndAnimeType (String name, String type);

    public Anime saveAnime(Anime anime);

}
