package com.verho.video.service;

import com.verho.video.model.Recommendation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@Data
public class VideoRecommendationsService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.video-recommendation.url}")
    private String baseUrl;


    public List<Recommendation> getRecommendationsByVideoId(Long videoId) {
        Recommendation[] response =
                restTemplate.getForEntity(
                        baseUrl + "/video/" + videoId,
                        Recommendation[].class).getBody();
        return Arrays.asList(response);
    }

    public void saveRecommendation(Recommendation recommendation) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject recommendationJSONObject = new JSONObject();
        recommendationJSONObject.put("rating", recommendation.getRating());
        recommendationJSONObject.put("comment", recommendation.getComment());
        recommendationJSONObject.put("videoId", recommendation.getVideoId());

        HttpEntity<String> request =
                new HttpEntity<String>(recommendationJSONObject.toString(), headers);

        restTemplate.postForEntity(baseUrl, request, String.class);
    }
}
