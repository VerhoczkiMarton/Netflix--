package com.verho.video.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VideoUpdate {
    private String name;
    private String url;
}
