package com.hronline.vm.jobTitle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateJobTitleVM implements Serializable {
    // Tên ngành nghề hoạt động
    @NotBlank(message = "Tên ngành nghề không được trống")
    @Size(max = 100, message = "Tên chức vụ không quá 100 ký tự")
    private String name;
}
