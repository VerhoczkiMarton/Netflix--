package com.verho.video.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Recommendation {
    private Long id;
    private Integer rating;
    private String comment;
    private Long videoId;
}