package com.verho.videorecommendation.controller;


import com.verho.videorecommendation.model.Recommendation;
import com.verho.videorecommendation.model.request.RequestRecommendation;
import com.verho.videorecommendation.model.request.RequestVideo;
import com.verho.videorecommendation.service.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
@AllArgsConstructor
public class RecommendationController {

    RecommendationService recommendationService;

    @GetMapping
    List<Recommendation> getRecommendationsByVideoId(@RequestBody RequestVideo requestVideo) {
        return recommendationService.getRecommendationsByVideoId(requestVideo);
    }

    @PostMapping
    void saveNewRecommendation(@RequestBody RequestRecommendation requestRecommendation) {
        recommendationService.saveRecommendation(requestRecommendation);
    }
}
