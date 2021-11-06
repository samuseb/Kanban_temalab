package Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private User assignedTo;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Board board;


    public Task(String name, String description, Category category, Board board){
        this.name = name;
        this.description = description;
        this.category = category;
        this.board = board;
    }
}
