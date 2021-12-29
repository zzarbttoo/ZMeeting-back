package com.muck.zmeeting.jpa.repository;

import org.apache.http.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
