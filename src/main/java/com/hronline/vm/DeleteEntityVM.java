package com.hronline.vm;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class DeleteEntityVM implements Serializable {
    private List<String> ids;
}
