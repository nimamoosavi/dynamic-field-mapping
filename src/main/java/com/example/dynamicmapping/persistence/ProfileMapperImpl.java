package com.example.dynamicmapping.persistence;

import com.example.dynamicmapping.persistence.exception.JsonNotParsedException;
import com.example.dynamicmapping.persistence.entity.ProfileEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileMapperImpl implements ProfileMapper{

    private final ObjectMapper objectMapper;


    @Override
    public ProfileEntity mapToProfileEntity(String json){
        JsonNode rootNode;
        try {
            rootNode = objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new JsonNotParsedException(e);
        }

        JsonNode profileNode = rootNode.path("payload").path("Profile");

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setCustomerId(profileNode.path("customerId").asText());
        profileEntity.setFirstname(profileNode.path("firstname").asText());
        profileEntity.setLastname(profileNode.path("lastname").asText());
        profileEntity.setStatus(profileNode.path("status").asText());
        profileEntity.setAddressLine(profileNode.path("addressLine").asText());
        profileEntity.setCity(profileNode.path("city").asText());
        profileEntity.setProvince(profileNode.path("province").asText());
        profileEntity.setPostalCode(profileNode.path("postalCode").asText());

        return profileEntity;
    }
}
