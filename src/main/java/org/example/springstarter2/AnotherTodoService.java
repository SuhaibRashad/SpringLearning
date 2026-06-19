package org.example.springstarter2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("anotherTodoService")

public class AnotherTodoService implements  TodoService{
    @Override
    public void doSomething() {
        System.out.println("Something from AnotherTodoService");
    }
}
