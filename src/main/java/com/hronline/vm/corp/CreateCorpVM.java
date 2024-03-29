package com.hronline.vm.corp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CreateCorpVM implements Serializable {
    private String name;
    private Set<String> industries;
    private String taxId;
    private String address;
    private String phone;
    private String website;
    private String description;
}
