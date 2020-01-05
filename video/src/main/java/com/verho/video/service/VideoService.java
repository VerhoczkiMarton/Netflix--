package com.verho.video.service;

import com.verho.video.model.Video;
import com.verho.video.model.request_response.VideoWithRecommendations;
import com.verho.video.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VideoService {

    VideoRepository videoRepository;

    VideoRecommendationsService videoRecommendationsService;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public List<VideoWithRecommendations> getAllVideosWithRecommendations() {
        return getAllVideos().stream().map(video -> VideoWithRecommendations.builder()
                .name(video.getName())
                .url(video.getYoutubeId())
                .recommendations(videoRecommendationsService.getRecommendationsByVideoId(video.getId()))
                .build()).collect(Collectors.toList());
    }

    public Video getVideoById(Long videoId) throws Exception {
        Optional<Video> video = videoRepository.findById(videoId);
        if (video.isPresent()) return video.get();
        throw new Exception();
    }
}
