package com.example.dynamicmapping.persistence;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.dynamicmapping.persistence.entity.ProfileEntity;
import com.example.dynamicmapping.persistence.respository.ProfileRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersistenceServiceImplTest {
    @InjectMocks
    private PersistenceServiceImpl persistenceServiceImpl;

    @Mock
    private ProfileMapper profileMapper;

    @Mock
    private ProfileRepository profileRepository;

    /**
     * Test {@link PersistenceServiceImpl#execute(String)}.
     * <p>
     * Method under test: {@link PersistenceServiceImpl#execute(String)}
     */
    @Test
    @DisplayName("Test execute to verify mapper")
    void testExecute_givenData_whenPersistCall_ThenVerify() {
        // Arrange
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setAddressLine("23 Main St");
        profileEntity.setCity("Oxford");
        profileEntity.setCustomerId("23");
        profileEntity.setFirstname("Jane");
        profileEntity.setLastname("Doe");
        profileEntity.setPostalCode("Postal Code");
        profileEntity.setProvince("Province");
        profileEntity.setStatus("Status");
        when(profileRepository.save(Mockito.any())).thenReturn(profileEntity);

        ProfileEntity profileEntity2 = new ProfileEntity();
        profileEntity2.setAddressLine("23 Main St");
        profileEntity2.setCity("Oxford");
        profileEntity2.setCustomerId("23");
        profileEntity2.setFirstname("Jane");
        profileEntity2.setLastname("Doe");
        profileEntity2.setPostalCode("Postal Code");
        profileEntity2.setProvince("Province");
        profileEntity2.setStatus("Status");
        when(profileMapper.mapToProfileEntity(Mockito.any())).thenReturn(profileEntity2);

        // Act
        persistenceServiceImpl.execute("Json");

        // Assert
        verify(profileMapper).mapToProfileEntity(eq("Json"));
    }

    /**
     * Test {@link PersistenceServiceImpl#execute(String)}.
     * <p>
     * Method under test: {@link PersistenceServiceImpl#execute(String)}
     */
    @Test
    @DisplayName("Test execute to verify persistance")
    void testExecute_givenData_whenPersistCall_ThenCheckPersist() {
        // Arrange
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setAddressLine("23 Main St");
        profileEntity.setCity("Oxford");
        profileEntity.setCustomerId("23");
        profileEntity.setFirstname("Jane");
        profileEntity.setLastname("Doe");
        profileEntity.setPostalCode("Postal Code");
        profileEntity.setProvince("Province");
        profileEntity.setStatus("Status");
        when(profileRepository.save(Mockito.any())).thenReturn(profileEntity);

        ProfileEntity profileEntity2 = new ProfileEntity();
        profileEntity2.setAddressLine("23 Main St");
        profileEntity2.setCity("Oxford");
        profileEntity2.setCustomerId("23");
        profileEntity2.setFirstname("Jane");
        profileEntity2.setLastname("Doe");
        profileEntity2.setPostalCode("Postal Code");
        profileEntity2.setProvince("Province");
        profileEntity2.setStatus("Status");
        when(profileMapper.mapToProfileEntity(Mockito.any())).thenReturn(profileEntity2);

        // Act
        persistenceServiceImpl.execute("Json");

        // Assert
        verify(profileRepository).save(isA(ProfileEntity.class));
    }
}
