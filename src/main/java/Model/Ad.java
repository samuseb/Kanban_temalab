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
public class Ad {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private Board board;

    public Ad(String name, Board board){
        this.name = name;
        this.board = board;
    }
}
