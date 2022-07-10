package com.extrieve.anime.service;

import com.extrieve.anime.entity.Anime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnimeServiceImplTest {

    @Autowired
    AnimeServiceImpl animeService;

    @Test
    void getAnimeByName() {
//        String title = "Kaguya-sama wa Kokurasetai: Ultra Romantic";
        String title = "Kaguya-sama";
        ResponseEntity<Collection<Anime>> payload = animeService.findAnimeByName(title);

        System.out.println(payload.getBody());
    }

}