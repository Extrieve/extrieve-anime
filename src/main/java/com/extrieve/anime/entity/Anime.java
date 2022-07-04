package com.extrieve.anime.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Getter
//@Setter
//@ToString
@Entity
@Table(name = "anime")
public class Anime {

    @Id
    @SequenceGenerator(
            name = "anime_sequence",
            sequenceName = "anime_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "anime_sequence"
    )
    private Long animeId;

    @Column(name = "anime_title")
    private String animeTitle;

    @Column(name = "anime_type")
    private String animeType;

    @Column(name = "anime_description")
    private String animeDescription;

    @Column(name = "anime_image_url")
    private String animeImageUrl;

    @Column(name = "anime_episode_count")
    private Integer animeEpisodeCount;

    @Column(name = "anime_studio")
    private String animeStudio;

    @Column(name = "rating")
    private String rating;
}
