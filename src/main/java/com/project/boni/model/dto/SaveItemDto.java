package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveItemDto implements Serializable {

    private String name;

    private String itemImage;

    private String description;

    private Long categoryId;
}
