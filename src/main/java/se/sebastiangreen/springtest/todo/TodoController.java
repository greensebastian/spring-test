package se.sebastiangreen.springtest.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("todo")
public class TodoController {
    
    @GetMapping("")
    public List<Todo> getMethodName() {
        List<Todo> todos = new ArrayList<Todo>();
        todos.add(new Todo("Implement repository"));
        todos.add(new Todo("Generate db migration"));
        todos.add(new Todo("Add post and get by id endpoints"));
        return todos;
    }
    
}
