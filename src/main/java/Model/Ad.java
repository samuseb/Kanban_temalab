package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ad {

    private long id;
    private String name;
    private Board board;

    public Ad(String name, Board board){
        this.name = name;
        this.board = board;
    }
}
