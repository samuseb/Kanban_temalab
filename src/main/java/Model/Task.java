package Model;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Task {

    private long id;
    private String name;
    private String description;
    private User assignedTo;
    private Category category;
    private Board board;



    public Task(String name, String description, Category category, Board board){
        this.name = name;
        this.description = description;
        this.category = category;
        this.board = board;
    }




}
