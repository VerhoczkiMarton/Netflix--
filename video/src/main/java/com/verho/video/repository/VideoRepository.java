package com.verho.video.repository;

import com.verho.video.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface VideoRepository extends JpaRepository<Video, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Video v SET v.name = ?2 WHERE v.id = ?1")
    void updateVideoNameById(Long id, String name);
}