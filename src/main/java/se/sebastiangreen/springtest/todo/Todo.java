package se.sebastiangreen.springtest.todo;

import java.util.UUID;

public class Todo {
    private UUID id;
    private String text;
    private boolean done;

    public Todo(String text){
        id = UUID.randomUUID();
        this.text = text;
        this.done = false;
    }

    public void SetDone(boolean done){
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
