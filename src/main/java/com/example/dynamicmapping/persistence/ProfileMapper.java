package com.example.dynamicmapping.persistence;

import com.example.dynamicmapping.persistence.entity.ProfileEntity;

public interface ProfileMapper {

    ProfileEntity mapToProfileEntity(String json);
}
