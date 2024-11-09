package com.example.dynamicmapping.fileprocessor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Profile {

    private final String customerId;
    private final String firstname;
    private final String lastname;
    private final String status;
    private final String addressLine;
    private final String city;
    private final String province;
    private final String postalCode;
}
