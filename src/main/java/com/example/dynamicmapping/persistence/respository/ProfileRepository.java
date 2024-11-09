package com.example.dynamicmapping.persistence.respository;

import com.example.dynamicmapping.persistence.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, String> {
}
