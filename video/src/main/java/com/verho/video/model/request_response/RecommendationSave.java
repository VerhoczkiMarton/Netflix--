package com.verho.video.model.request_response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendationSave {
    private Integer rating;
    private String comment;
}
