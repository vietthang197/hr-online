package com.hronline.vm;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UpdateCorpIndustryVM implements Serializable {

    @NotBlank(message = "Id không được trống")
    @Size(max = 100, message = "Id không quá 100 ký tự")
    private String id;

    @NotBlank(message = "Tên ngành nghề không được trống")
    @Size(max = 100, message = "Tên ngành nghề không quá 100 ký tự")
    private String name;
}
