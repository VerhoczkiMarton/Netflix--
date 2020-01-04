package com.verho.video.controller;

import com.verho.video.model.Recommendation;
import com.verho.video.model.request_response.RecommendationSave;
import com.verho.video.service.VideoRecommendationsService;
import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@AllArgsConstructor
public class RecommendationController {
    VideoRecommendationsService videoRecommendationsService;

    @PutMapping("/{videoId}/recommendation/{id}")
    void saveNewRecommendation(@RequestBody RecommendationSave recommendationSave) throws JSONException {
        videoRecommendationsService.saveRecommendation(
                Recommendation.builder()
                        .comment(recommendationSave.getComment())
                        .rating(recommendationSave.getRating())
                        .videoId(recommendationSave.getVideoId())
                        .build()
        );
    }
}
