package com.kitsune.todo_list_crud.controller;

import com.kitsune.todo_list_crud.dto.TaskRequestDTO;
import com.kitsune.todo_list_crud.dto.TaskResponseDTO;
import com.kitsune.todo_list_crud.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(){
        List<TaskResponseDTO> task = taskService.getAllTasks();

        return ResponseEntity.ok(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id){
        TaskResponseDTO task = taskService.getTaskById(id);

        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO taskRequestDTO){
        TaskResponseDTO task = taskService.createTask(taskRequestDTO);

        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO taskRequestDTO){
        TaskResponseDTO task = taskService.updateTaskById(id,taskRequestDTO);

        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdTask(@PathVariable Long id){
        taskService.deleteTaskById(id);

        return ResponseEntity.noContent().build();
    }
}
