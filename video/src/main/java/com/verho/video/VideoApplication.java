package com.verho.video;

import com.verho.video.model.Video;
import com.verho.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class VideoApplication {

	@Autowired
	VideoRepository videoRepository;

	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	@Profile("production")
	public CommandLineRunner init() {
		return args -> {
			Video video0 = Video.builder()
					.name("My Webm Collection #40 memes")
					.url("https://www.youtube.com/watch?v=1NtOYmLZq3A")
					.build();

			Video video1 = Video.builder()
					.name("Fosterék háza képzeletbeli barátoknak s03 SPECIAL")
					.url("https://www.youtube.com/watch?v=avSK2u5aiZE")
					.build();

			Video video2 = Video.builder()
					.name("If Google Was A Guy (Full Series)")
					.url("https://www.youtube.com/watch?v=Cxqca4RQd_M")
					.build();

			videoRepository.save(video0);
			videoRepository.save(video1);
			videoRepository.save(video2);
		};
	}
}
