package com.kitsune.todo_list_crud.mapper;

import com.kitsune.todo_list_crud.dto.TaskRequestDTO;
import com.kitsune.todo_list_crud.dto.TaskResponseDTO;
import com.kitsune.todo_list_crud.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    TaskEntity toEntity(TaskRequestDTO taskRequestDTO);

    TaskResponseDTO toResponseDTO(TaskEntity taskEntity);

    List<TaskResponseDTO> toResponseDTOList(List<TaskEntity> taskEntities);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(TaskRequestDTO taskRequestDTO, @MappingTarget TaskEntity taskEntity);
}
