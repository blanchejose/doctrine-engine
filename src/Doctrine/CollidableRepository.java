package Doctrine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollidableRepository implements Iterable<StaticEntity> {
   //  tableau de tous les enfants qui peuvent entrer en collission
    //cette classe garde en memoire les collision et garder la liste de tous ce qui peut entrer en collision
    private static CollidableRepository instance;
    private final List<StaticEntity> registeredEntities;
    // statictEntityvcest du polimorphisme car elle contient plusieurs entité le but cest de êrmettre au programmeur de

    public static CollidableRepository getInstance() {
        if (instance == null) {
            instance = new CollidableRepository();
        }
        return instance;
    }

    public void registerEntity(StaticEntity entity) {
        registeredEntities.add(entity);
    }
    public void unregisterEntity(StaticEntity entity) {
        registeredEntities.remove(entity);
    }
    public void RegisteredEntities(Collection<StaticEntity> entities) {//collection cest super large libre au programeur de choisir cela
        registeredEntities.addAll(entities);
    }
    public  void unregisterEntities(Collection<StaticEntity> entities) {
        registeredEntities.removeAll(entities);
    }
    public int count(){
        return registeredEntities.size();
    }
    @Override
    public Iterator<StaticEntity> iterator() {
        return registeredEntities.iterator();
    }
    private CollidableRepository() {
        registeredEntities = new ArrayList<>();
    }
}
