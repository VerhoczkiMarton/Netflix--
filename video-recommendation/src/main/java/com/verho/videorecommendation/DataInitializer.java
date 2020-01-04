package com.verho.videorecommendation;


import com.verho.videorecommendation.model.Recommendation;
import com.verho.videorecommendation.repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    RecommendationRepository recommendationRepository;

    @Override
    public void run(String... args) throws Exception {
        Recommendation recommendation1 = Recommendation.builder()
                .comment("Nice")
                .rating(5)
                .videoId(1L)
                .build();

        recommendationRepository.save(recommendation1);

        Recommendation recommendation2 = Recommendation.builder()
                .comment("Yea its nice")
                .rating(4)
                .videoId(1L)
                .build();

        recommendationRepository.save(recommendation2);


        Recommendation recommendation3 = Recommendation.builder()
                .comment("I dont understand")
                .rating(1)
                .videoId(3L)
                .build();

        recommendationRepository.save(recommendation3);
    }
}
