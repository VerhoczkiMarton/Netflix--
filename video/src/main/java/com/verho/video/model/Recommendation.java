package com.verho.video.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recommendation {
    private Long id;
    private Integer rating;
    private String comment;
    private Long videoId;
}
