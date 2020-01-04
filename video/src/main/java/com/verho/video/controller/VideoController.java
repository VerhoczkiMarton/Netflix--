package com.verho.video.controller;

import com.verho.video.model.Video;
import com.verho.video.model.request.VideoUpdate;
import com.verho.video.service.UpdateService;
import com.verho.video.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/video")
@AllArgsConstructor
public class VideoController {

    VideoService videoService;

    UpdateService updateService;

    @GetMapping
    List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @PostMapping("/{videoId}")
    void updateVideoNameById(@PathVariable("videoId") Long videoId, @RequestBody VideoUpdate videoUpdate) {
        updateService.updateVideo(videoId, videoUpdate);
    }
}
