package com.board.back.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean completed;

    @Column(nullable = false)
    private String todoName;

    @Builder
    public Todo(Long id, boolean completed, String todoName) {
        this.id = id;
        this.completed = completed;
        this.todoName = todoName;
    }

    public void modifyCompleted() {
        this.completed = !completed;
    }
}
