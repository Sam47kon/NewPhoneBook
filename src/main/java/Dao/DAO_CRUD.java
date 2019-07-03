package Dao;

import java.util.List;

public interface DAO_CRUD<Entity, Key> {
    List<Entity> readAll();

    void create(Entity person);

    Entity readById(Key key);

    void update(Entity person);

    void delete(Entity person);
}