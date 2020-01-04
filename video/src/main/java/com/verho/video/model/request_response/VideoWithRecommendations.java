package com.verho.video.model.request_response;

import com.verho.video.model.Recommendation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class VideoWithRecommendations {
    private String name;
    private String url;
    private List<Recommendation> recommendations;
}
