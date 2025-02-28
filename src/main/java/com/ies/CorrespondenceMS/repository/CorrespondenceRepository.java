package com.ies.CorrespondenceMS.repository;

import com.ies.CorrespondenceMS.entity.CorrespondenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrespondenceRepository extends JpaRepository<CorrespondenceEntity, Integer> {
}
