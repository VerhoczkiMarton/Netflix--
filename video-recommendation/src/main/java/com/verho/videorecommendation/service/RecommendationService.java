package com.verho.videorecommendation.service;

import com.verho.videorecommendation.model.Recommendation;
import com.verho.videorecommendation.model.request.RequestRecommendation;
import com.verho.videorecommendation.repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecommendationService {
    RecommendationRepository recommendationRepository;


    public List<Recommendation> getRecommendationsByVideoId(Long videoId) {
        return recommendationRepository.findAllByVideoId(videoId);
    }

    public void saveRecommendation(RequestRecommendation requestRecommendation) {
        recommendationRepository.save(
                Recommendation.builder()
                        .comment(requestRecommendation.getComment())
                        .rating(requestRecommendation.getRating())
                        .videoId(requestRecommendation.getVideoId())
                        .build()
        );
    }
}
