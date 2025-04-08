package com.sharanya.todo_api;

import com.sharanya.todo_api.ToDo;
import com.sharanya.todo_api.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;
    @Autowired
    private ToDoRepository toDoRepository;
    // Create ToDo
    @PostMapping
    public ToDo createToDo(@RequestBody ToDo todo) {
        return toDoService.createToDo(todo);
    }

    // Get all ToDos
    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoService.getAllToDos();
    }

    // Get ToDo by ID
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        Optional<ToDo> todo = toDoService.getToDoById(id);
        return todo.map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update ToDo
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDo updatedToDo) {
        Optional<ToDo> todo = toDoService.updateToDo(id, updatedToDo);
        return todo.map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Delete ToDo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id) {
        return toDoService.deleteToDo(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ToDo> patchTodo(@PathVariable Long id, @RequestBody TodoPatchDto patchDto) {
    Optional<ToDo> optionalTodo = toDoRepository.findById(id);

    if (optionalTodo.isPresent()) {
        ToDo todo = optionalTodo.get();

        // Update only non-null fields from patchDto
        if (patchDto.getTitle() != null) {
            todo.setTitle(patchDto.getTitle());
        }
        if (patchDto.getDescription() != null) {
            todo.setDescription(patchDto.getDescription());
        }
        if (patchDto.getCompleted() != null) {
            todo.setCompleted(patchDto.getCompleted());
        }

        ToDo updatedTodo = toDoRepository.save(todo);
        return ResponseEntity.ok(updatedTodo);
    } else {
        return ResponseEntity.notFound().build();
    }
}

}
