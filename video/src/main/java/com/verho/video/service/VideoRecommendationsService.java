package com.verho.video.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@Data
public class VideoRecommendationsService {

    private RestTemplate restTemplate;

    @Value("${service.video-recommendation.url}")
    private String baseUrl;


}
