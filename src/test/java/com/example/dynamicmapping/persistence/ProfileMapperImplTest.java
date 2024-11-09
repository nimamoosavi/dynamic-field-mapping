package com.example.dynamicmapping.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.dynamicmapping.persistence.entity.ProfileEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProfileMapperImplTest {
    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private ProfileMapperImpl profileMapperImpl;

    /**
     * Test {@link ProfileMapperImpl#mapToProfileEntity(String)}.
     * <p>
     * Method under test: {@link ProfileMapperImpl#mapToProfileEntity(String)}
     */
    @Test
    @DisplayName("Test mapToProfileEntity(String)")
    void testMapToProfileEntity() throws JsonProcessingException {
        // Arrange
        ArrayNode arrayNode = mock(ArrayNode.class);
        when(arrayNode.path(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
        ArrayNode arrayNode2 = mock(ArrayNode.class);
        when(arrayNode2.path(Mockito.<String>any())).thenReturn(arrayNode);
        ArrayNode arrayNode3 = mock(ArrayNode.class);
        when(arrayNode3.path(Mockito.<String>any())).thenReturn(arrayNode2);
        when(objectMapper.readTree(Mockito.<String>any())).thenReturn(arrayNode3);

        // Act
        ProfileEntity actualMapToProfileEntityResult = profileMapperImpl.mapToProfileEntity("Json");

        // Assert
        verify(objectMapper).readTree(eq("Json"));
        verify(arrayNode, atLeast(1)).path(Mockito.<String>any());
        verify(arrayNode2).path(eq("Profile"));
        verify(arrayNode3).path(eq("payload"));
        assertEquals("", actualMapToProfileEntityResult.getAddressLine());
        assertEquals("", actualMapToProfileEntityResult.getCity());
        assertEquals("", actualMapToProfileEntityResult.getCustomerId());
        assertEquals("", actualMapToProfileEntityResult.getFirstname());
        assertEquals("", actualMapToProfileEntityResult.getLastname());
        assertEquals("", actualMapToProfileEntityResult.getPostalCode());
        assertEquals("", actualMapToProfileEntityResult.getProvince());
        assertEquals("", actualMapToProfileEntityResult.getStatus());
    }

    /**
     * Test {@link ProfileMapperImpl#mapToProfileEntity(String)}.
     * <ul>
     *   <li>Given {@link ArrayNode} {@link ArrayNode#path(String)} return
     * Instance.</li>
     *   <li>Then calls {@link ArrayNode#path(String)}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ProfileMapperImpl#mapToProfileEntity(String)}
     */
    @Test
    @DisplayName("Test mapToProfileEntity(String); given ArrayNode path(String) return Instance; then calls path(String)")
    void testMapToProfileEntity_givenArrayNodePathReturnInstance_thenCallsPath() throws JsonProcessingException {
        // Arrange
        ArrayNode arrayNode = mock(ArrayNode.class);
        when(arrayNode.path(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
        when(objectMapper.readTree(Mockito.<String>any())).thenReturn(arrayNode);

        // Act
        ProfileEntity actualMapToProfileEntityResult = profileMapperImpl.mapToProfileEntity("Json");

        // Assert
        verify(objectMapper).readTree(eq("Json"));
        verify(arrayNode).path(eq("payload"));
        assertEquals("", actualMapToProfileEntityResult.getAddressLine());
        assertEquals("", actualMapToProfileEntityResult.getCity());
        assertEquals("", actualMapToProfileEntityResult.getCustomerId());
        assertEquals("", actualMapToProfileEntityResult.getFirstname());
        assertEquals("", actualMapToProfileEntityResult.getLastname());
        assertEquals("", actualMapToProfileEntityResult.getPostalCode());
        assertEquals("", actualMapToProfileEntityResult.getProvince());
        assertEquals("", actualMapToProfileEntityResult.getStatus());
    }

    /**
     * Test {@link ProfileMapperImpl#mapToProfileEntity(String)}.
     * <ul>
     *   <li>Given {@link ArrayNode} {@link ArrayNode#path(String)} return
     * Instance.</li>
     *   <li>Then calls {@link ArrayNode#path(String)}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ProfileMapperImpl#mapToProfileEntity(String)}
     */
    @Test
    @DisplayName("Test mapToProfileEntity(String); given ArrayNode path(String) return Instance; then calls path(String)")
    void testMapToProfileEntity_givenArrayNodePathReturnInstance_thenCallsPath2() throws JsonProcessingException {
        // Arrange
        ArrayNode arrayNode = mock(ArrayNode.class);
        when(arrayNode.path(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
        ArrayNode arrayNode2 = mock(ArrayNode.class);
        when(arrayNode2.path(Mockito.<String>any())).thenReturn(arrayNode);
        when(objectMapper.readTree(Mockito.<String>any())).thenReturn(arrayNode2);

        // Act
        ProfileEntity actualMapToProfileEntityResult = profileMapperImpl.mapToProfileEntity("Json");

        // Assert
        verify(objectMapper).readTree(eq("Json"));
        verify(arrayNode).path(eq("Profile"));
        verify(arrayNode2).path(eq("payload"));
        assertEquals("", actualMapToProfileEntityResult.getAddressLine());
        assertEquals("", actualMapToProfileEntityResult.getCity());
        assertEquals("", actualMapToProfileEntityResult.getCustomerId());
        assertEquals("", actualMapToProfileEntityResult.getFirstname());
        assertEquals("", actualMapToProfileEntityResult.getLastname());
        assertEquals("", actualMapToProfileEntityResult.getPostalCode());
        assertEquals("", actualMapToProfileEntityResult.getProvince());
        assertEquals("", actualMapToProfileEntityResult.getStatus());
    }

    /**
     * Test {@link ProfileMapperImpl#mapToProfileEntity(String)}.
     * <ul>
     *   <li>Given {@link ArrayNode} {@link ArrayNode#path(String)} return
     * Instance.</li>
     *   <li>Then calls {@link ArrayNode#path(String)}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ProfileMapperImpl#mapToProfileEntity(String)}
     */
    @Test
    @DisplayName("Test mapToProfileEntity(String); given ArrayNode path(String) return Instance; then calls path(String)")
    void testMapToProfileEntity_givenArrayNodePathReturnInstance_thenCallsPath3() throws JsonProcessingException {
        // Arrange
        ArrayNode arrayNode = mock(ArrayNode.class);
        when(arrayNode.path(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
        ArrayNode arrayNode2 = mock(ArrayNode.class);
        when(arrayNode2.path(Mockito.<String>any())).thenReturn(arrayNode);
        ArrayNode arrayNode3 = mock(ArrayNode.class);
        when(arrayNode3.path(Mockito.<String>any())).thenReturn(arrayNode2);
        when(objectMapper.readTree(Mockito.<String>any())).thenReturn(arrayNode3);

        // Act
        ProfileEntity actualMapToProfileEntityResult = profileMapperImpl.mapToProfileEntity("Json");

        // Assert
        verify(objectMapper).readTree(eq("Json"));
        verify(arrayNode, atLeast(1)).path(Mockito.any());
        verify(arrayNode2).path(eq("Profile"));
        verify(arrayNode3).path(eq("payload"));
        assertEquals("", actualMapToProfileEntityResult.getAddressLine());
        assertEquals("", actualMapToProfileEntityResult.getCity());
        assertEquals("", actualMapToProfileEntityResult.getCustomerId());
        assertEquals("", actualMapToProfileEntityResult.getFirstname());
        assertEquals("", actualMapToProfileEntityResult.getLastname());
        assertEquals("", actualMapToProfileEntityResult.getPostalCode());
        assertEquals("", actualMapToProfileEntityResult.getProvince());
        assertEquals("", actualMapToProfileEntityResult.getStatus());
    }

    /**
     * Test {@link ProfileMapperImpl#mapToProfileEntity(String)}.
     * <ul>
     *   <li>Given {@link ObjectMapper} {@link ObjectMapper#readTree(String)} return
     * Instance.</li>
     * </ul>
     * <p>
     * Method under test: {@link ProfileMapperImpl#mapToProfileEntity(String)}
     */
    @Test
    @DisplayName("Test mapToProfileEntity(String); given ObjectMapper readTree(String) return Instance")
    void testMapToProfileEntity_givenObjectMapperReadTreeReturnInstance() throws JsonProcessingException {
        // Arrange
        when(objectMapper.readTree(Mockito.<String>any())).thenReturn(MissingNode.getInstance());

        // Act
        ProfileEntity actualMapToProfileEntityResult = profileMapperImpl.mapToProfileEntity("Json");

        // Assert
        verify(objectMapper).readTree(eq("Json"));
        assertEquals("", actualMapToProfileEntityResult.getAddressLine());
        assertEquals("", actualMapToProfileEntityResult.getCity());
        assertEquals("", actualMapToProfileEntityResult.getCustomerId());
        assertEquals("", actualMapToProfileEntityResult.getFirstname());
        assertEquals("", actualMapToProfileEntityResult.getLastname());
        assertEquals("", actualMapToProfileEntityResult.getPostalCode());
        assertEquals("", actualMapToProfileEntityResult.getProvince());
        assertEquals("", actualMapToProfileEntityResult.getStatus());
    }
}
