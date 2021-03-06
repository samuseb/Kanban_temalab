package kanban.model;

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
    private User user;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Board board;

    public Task(String name, String description, Category category, Board board, User user){
        this.name = name;
        this.description = description;
        this.category = category;
        this.board = board;
        this.user = user;

        board.addTask(this);
        category.addTask(this);
        user.addTask(this);
    }

    public Task(String name, String description, Category category, Board board){
        this.name = name;
        this.description = description;
        this.category = category;
        this.board = board;

        board.addTask(this);
        category.addTask(this);
    }

    public Task(String name, String description, Board board){
        this.name = name;
        this.description = description;
        this.board = board;

        board.addTask(this);
    }

    public long getBoardsProjectId(){
        return board.getProject().getId();
    }
}
