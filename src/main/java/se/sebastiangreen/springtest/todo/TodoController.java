package se.sebastiangreen.springtest.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("todos")
public class TodoController {
    private final TodoRepository repository;

    public TodoController(final TodoRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    public List<Todo> getMethodName() {
        List<Todo> todos = new ArrayList<Todo>();
        this.repository.findAll().forEach(todos::add);

        return todos;
    }

    @PostMapping("seed")
    public void addABunch(){
        List<Todo> todos = new ArrayList<Todo>();
        todos.add(new Todo("Implement repository"));
        todos.add(new Todo("Generate db migration"));
        todos.add(new Todo("Add post and get by id endpoints"));

        repository.saveAll(todos);
    }
}
