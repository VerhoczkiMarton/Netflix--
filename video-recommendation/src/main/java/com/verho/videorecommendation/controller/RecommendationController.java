package com.verho.videorecommendation.controller;


import com.verho.videorecommendation.model.Recommendation;
import com.verho.videorecommendation.model.request.RequestRecommendation;
import com.verho.videorecommendation.service.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
@AllArgsConstructor
public class RecommendationController {

    RecommendationService recommendationService;

    @GetMapping("/video/{id}")
    List<Recommendation> getRecommendationsByVideoId(@PathVariable("id") Long videoId) {
        return recommendationService.getRecommendationsByVideoId(videoId);
    }

    @PostMapping
    void saveNewRecommendation(@RequestBody RequestRecommendation requestRecommendation) {
        recommendationService.saveRecommendation(requestRecommendation);
    }
}
