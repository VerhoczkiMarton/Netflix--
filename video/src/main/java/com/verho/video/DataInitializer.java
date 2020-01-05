package com.verho.video;

import com.verho.video.model.Video;
import com.verho.video.repository.VideoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    VideoRepository videoRepository;

    @Override
    public void run(String... args) throws Exception {
        Video video1 = Video.builder()
                .name("My Webm Collection #40 memes")
                .youtubeId("gg7_grAY1yY")
                .build();

        videoRepository.saveAndFlush(video1);

        Video video2 = Video.builder()
                .name("Fosterék háza képzeletbeli barátoknak s03 SPECIAL")
                .youtubeId("avSK2u5aiZE")
                .build();

        videoRepository.save(video2);

        Video video3 = Video.builder()
                .name("If Google Was A Guy (Full Series)")
                .youtubeId("Cxqca4RQd_M")
                .build();

        videoRepository.save(video3);
    }
}
