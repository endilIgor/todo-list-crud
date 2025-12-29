package com.kitsune.todo_list_crud.repository;

import com.kitsune.todo_list_crud.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
