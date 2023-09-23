package com.hronline.vm.location;

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
public class CreateJobLocationVM implements Serializable {
    // Tên ngành nghề hoạt động
    @NotBlank(message = "Địa chỉ được trống")
    @Size(max = 100, message = "Địa chỉ không quá 100 ký tự")
    private String name;
}
