package Dao;

import java.util.List;

public interface DAO_CRUD<Entity, Key> {
    void create(Entity person);

    void delete(Entity person);

    Entity readById(Key key);

    List<Entity> readAll();

    void update(Entity person);
}