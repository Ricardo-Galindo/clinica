package com.Squad03.demo.dto;

import java.util.UUID;

public record UserResponseDTO(UUID id,String name, String userType, String email, String phone, String createdBy, String dateOfBirth) {
}
