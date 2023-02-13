package se.sebastiangreen.springtest.todo;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "todos")
@Entity
public class Todo {
    @Id
    private UUID id;
    private String text;
    private boolean done;

    public Todo(){
        this("");
    }

    public Todo(String text){
        id = UUID.randomUUID();
        this.text = text;
        this.done = false;
    }

    public void setDone(boolean done){
        this.done = done;
    }

    public UUID getId(){
        return id;
    }

    public String getText(){
        return text;
    }

    public boolean getDone(){
        return done;
    }
}
