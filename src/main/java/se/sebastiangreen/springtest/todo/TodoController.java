package se.sebastiangreen.springtest.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("todos")
public class TodoController {
    private final TodoRepository repository;

    public TodoController(final TodoRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    public List<Todo> getAll() {
        var todos = new ArrayList<Todo>();
        this.repository.findAll().forEach(todos::add);

        return todos;
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getById(@PathVariable UUID id) {
        var todo = this.repository.findById(id);

        if (todo.isPresent()){
            return new ResponseEntity<Todo>(todo.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("seed")
    public void addABunch(){
        var todos = new ArrayList<Todo>();
        todos.add(new Todo("Implement repository"));
        todos.add(new Todo("Generate db migration"));
        todos.add(new Todo("Add post and get by id endpoints"));

        repository.saveAll(todos);
    }
}
