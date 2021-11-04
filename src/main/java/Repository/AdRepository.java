package Repository;

import Model.Ad;

import java.util.List;

public interface AdRepository {

    public Ad save(Ad ad);

    public void delete(Ad ad);

    public List findByName(String name);
}
