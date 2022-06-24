package com.extrieve.anime.repository;

import com.extrieve.anime.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    public Anime findByAnimeId(String animeId);

    public Collection<Anime> findByAnimeTitle(String animeTitle);

    public Collection<Anime> findByAnimeTitleIgnoreCase(String animeTitle);

    public Collection<Anime> getAnimeByAnimeTitleAndAnimeType (String animeTitle, String animeType);

    public Anime save(Anime anime);
}
