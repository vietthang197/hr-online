package com.hronline.vm.corp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCorpVM implements Serializable {
    private String id;
    private String name;
    private Set<String> industries;
    private String taxId;
    private String address;
    private String phone;
    private String website;
    private String description;
}
