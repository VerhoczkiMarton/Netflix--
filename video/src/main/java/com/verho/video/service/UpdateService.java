package com.verho.video.service;

import com.verho.video.model.request_response.VideoUpdate;
import com.verho.video.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateService {

    VideoRepository videoRepository;

    public void updateVideo(Long videoId, VideoUpdate videoUpdate) {
        String name = videoUpdate.getName();
        String url = videoUpdate.getUrl();
        if (name != null) videoRepository.updateVideoNameById(videoId, name);
        if (url != null) videoRepository.updateVideoUrlById(videoId, url);
    }
}
