package com.verho.video.controller;

import com.verho.video.model.Video;
import com.verho.video.model.request_response.VideoUpdate;
import com.verho.video.model.request_response.VideoWithRecommendations;
import com.verho.video.service.UpdateService;
import com.verho.video.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class VideoController {

    VideoService videoService;

    UpdateService updateService;

    @GetMapping
    List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/{videoId}")
    Video getVideoInfo(@PathVariable("videoId") Long videoId) throws Exception {
        Video video = videoService.getVideoById(videoId);
        return video;
    }

    @GetMapping("/all")
    List<VideoWithRecommendations> getAllVideosWithRecommendations() {
        return videoService.getAllVideosWithRecommendations();
    }

    @PostMapping("/{videoId}")
    void updateVideoNameById(@PathVariable("videoId") Long videoId, @RequestBody VideoUpdate videoUpdate) {
        updateService.updateVideo(videoId, videoUpdate);
    }
}
