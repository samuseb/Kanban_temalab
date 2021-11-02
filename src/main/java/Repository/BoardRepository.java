package Repository;

import Model.Board;

import java.util.List;

public interface BoardRepository {

    public Board save(Board board);

    public void delete(Board board);

    public List findByName(String name);

}
