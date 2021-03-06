package kanban.model;

import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "board")
    private List<Task> tasks;

    @OneToMany(mappedBy = "board")
    private List<Ad> ads;

    @ManyToOne
    private Project project;

    public Board(String title){ this.title = title; }

    public void addTask(Task task){
        if (tasks == null){
            tasks = new ArrayList<Task>();
        }

        tasks.add(task);
        task.setBoard(this);
    }

    public void removeTask(Task task){
        tasks.remove(task);
        task.setBoard(null);
    }

    public void addAd(Ad ad){
        if (ads == null){
            ads = new ArrayList<Ad>();
        }

        ads.add(ad);
        ad.setBoard(this);
    }

    public void removeAd(Ad ad){
        ads.remove(ad);
        ad.setBoard(null);
    }
}
