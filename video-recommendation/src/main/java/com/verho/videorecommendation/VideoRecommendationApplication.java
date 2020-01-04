package com.verho.videorecommendation;

import com.verho.videorecommendation.model.Recommendation;
import com.verho.videorecommendation.repository.RecommendationRepository;
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
public class VideoRecommendationApplication {

	@Autowired
	RecommendationRepository recommendationRepository;

	public static void main(String[] args) {
		SpringApplication.run(VideoRecommendationApplication.class, args);
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
			Recommendation recommendation0 = Recommendation.builder()
					.comment("Nice")
					.rating(5)
					.videoId(0L)
					.build();

			Recommendation recommendation1 = Recommendation.builder()
					.comment("Yea its nice")
					.rating(4)
					.videoId(0L)
					.build();

			Recommendation recommendation2 = Recommendation.builder()
					.comment("I dont understand")
					.rating(1)
					.videoId(2L)
					.build();

			recommendationRepository.save(recommendation0);
			recommendationRepository.save(recommendation1);
			recommendationRepository.save(recommendation2);
		};
	}
}
