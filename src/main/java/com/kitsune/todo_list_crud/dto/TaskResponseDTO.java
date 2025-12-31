package com.kitsune.todo_list_crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {

    private Long id;

    private String name;

    private String description;

    private String category;

    private boolean completed;
}
