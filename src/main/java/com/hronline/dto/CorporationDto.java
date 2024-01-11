package com.hronline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationDto implements Serializable {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String taxId;
    private String website;
    private String description;
    private String industries;
}
