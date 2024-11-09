package com.example.dynamicmapping.persistence;

import com.example.dynamicmapping.persistence.entity.ProfileEntity;
import com.example.dynamicmapping.persistence.respository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PersistenceServiceImpl implements PersistenceService {

    private final ProfileRepository profileRepository;

    private final ProfileMapper profileMapper;

    @Override
    @Transactional
    public void execute(String json) {
        ProfileEntity profileEntity = profileMapper.mapToProfileEntity(json);
        profileRepository.save(profileEntity);
    }
}
