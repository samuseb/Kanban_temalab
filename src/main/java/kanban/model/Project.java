package kanban.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @OneToMany(mappedBy = "project")
    private List<Board> boards;

    public Project(String name){ this.name = name; }


    public void addBoard(Board board){
        if (boards == null){
            boards = new ArrayList<Board>();
        }

        boards.add(board);
        board.setProject(this);
    }

    public void removeBoard(Board board) {
        boards.remove(board);
        board.setProject(null);
    }

}
