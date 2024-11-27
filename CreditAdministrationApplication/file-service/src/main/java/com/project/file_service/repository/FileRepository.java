package com.project.file_service.repository;

import com.project.file_service.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity,Long> {

    FileEntity findByCreditIdAndType(long creditId, int type);
    void deleteByCreditId(long creditId);
}
