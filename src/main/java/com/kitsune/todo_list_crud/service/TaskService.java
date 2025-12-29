package com.kitsune.todo_list_crud.service;

import com.kitsune.todo_list_crud.dto.TaskRequestDTO;
import com.kitsune.todo_list_crud.dto.TaskResponseDTO;
import com.kitsune.todo_list_crud.entity.TaskEntity;
import com.kitsune.todo_list_crud.mapper.TaskMapper;
import com.kitsune.todo_list_crud.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Transactional(readOnly = true)
    public List<TaskResponseDTO> getAllTasks(){
        List<TaskEntity> task = taskRepository.findAll();

        return taskMapper.toResponseDTOList(task);
    }

    @Transactional(readOnly = true)
    public TaskResponseDTO getTaskById(Long id){
        TaskEntity task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não existe: " + id));

        return taskMapper.toResponseDTO(task);
    }

    @Transactional
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO){
        TaskEntity task = taskMapper.toEntity(taskRequestDTO);

        TaskEntity savedTask = taskRepository.save(task);

        return taskMapper.toResponseDTO(savedTask);
    }

    @Transactional
    public TaskResponseDTO updateTaskById(Long id, TaskRequestDTO taskRequestDTO){
        TaskEntity existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não existe: " + id));

        taskMapper.updateEntityFromDTO(taskRequestDTO,existingTask);

        TaskEntity savedTask = taskRepository.save(existingTask);

        return taskMapper.toResponseDTO(savedTask);
    }

    @Transactional
    public void deleteTaskById(Long id){
        TaskEntity existingTask = taskRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Id não existe: " + id));
        taskRepository.delete(existingTask);
    }
}
