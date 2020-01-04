package com.verho.videorecommendation.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestRecommendation {
    private Integer rating;
    private String comment;
    private Long videoId;
}
