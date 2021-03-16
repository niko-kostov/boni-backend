package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditItemDto implements Serializable {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    private String itemImage;

    private String description;

    @NotNull
    private Long categoryId;
}
