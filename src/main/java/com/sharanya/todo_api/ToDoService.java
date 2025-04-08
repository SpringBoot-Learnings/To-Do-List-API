package com.sharanya.todo_api;

import com.sharanya.todo_api.ToDo;
import com.sharanya.todo_api.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    
    @Autowired
    private ToDoRepository toDoRepository;

    // Get all To-Dos
    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    // Get To-Do by ID
    public Optional<ToDo> getToDoById(Long id) {
        return toDoRepository.findById(id);
    }

    // Create To-Do
    public ToDo createToDo(ToDo todo) {
        return toDoRepository.save(todo);
    }
    
    //Update To DO
    public Optional<ToDo> updateToDo(Long id, ToDo updatedToDo) {
        return toDoRepository.findById(id).map(todo -> {
            todo.setTitle(updatedToDo.getTitle());   // or other fields
            todo.setDescription(updatedToDo.getDescription());
            todo.setCompleted(updatedToDo.isCompleted());
            return toDoRepository.save(todo);
        });
    }


    // Delete To-Do
    public ResponseEntity<Void> deleteToDo(Long id) {
    if (toDoRepository.existsById(id)) {
        toDoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
