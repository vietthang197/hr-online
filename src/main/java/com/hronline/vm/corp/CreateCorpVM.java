package com.hronline.vm.corp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CreateCorpVM implements Serializable {
    private String name;
}
