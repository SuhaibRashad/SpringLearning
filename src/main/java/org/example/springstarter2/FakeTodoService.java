package org.example.springstarter2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("fakeTodoService")
@Primary
public class FakeTodoService implements TodoService{
    @Override
    public void doSomething() {
        System.out.println("Something from FakeTodo");
    }
}
