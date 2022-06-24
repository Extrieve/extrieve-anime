package com.extrieve.anime.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class AnimeTest {

    @Autowired
    private Anime anime;

    @BeforeEach
    void setUp() {
        anime = Anime.builder()
//                .id(1L)
                .animeTitle("Test Title")
                .animeDescription("Test Description")
                .build();
    }

    @Test
    void getId() {
        System.out.println(this.anime);
//        assertEquals(1L, anime.getId());
    }

    @Test
    void printToString() {
        String myStr = anime.toString();
        System.out.println(myStr);
    }
}