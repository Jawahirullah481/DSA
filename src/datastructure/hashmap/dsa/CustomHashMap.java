package datastructure.hashmap.dsa;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private ArrayList<LinkedList<Entity<K, V>>> list;
    private int size = 0;
    private float loadFactor = 0.5f;

    public CustomHashMap() {
        list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
    }

    private static class Entity<K, V> {
        K key;
        V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity<K, V>> entities = list.get(hash);
        for(Entity entity : entities) {
            if(entity.key.equals(key)) {
                entity.value = value;
                return;
            }
        }

        if((float)(size) / list.size() > loadFactor) {

        }
        entities.add(new Entity<>(key, value));
        size++;
    }


    private void reHash() {
        ArrayList<LinkedList<Entity<K, V>>> old = list;
        list = new ArrayList<>(old.size() * 2);

        size = 0;
        for(int i = 0; i < list.size(); i++) {
            list.add(new LinkedList<>());
        }

        for(LinkedList<Entity<K, V>> entities : old) {
            for(Entity<K, V> entity : entities) {
                put(entity.key, entity.value);
            }
        }
    }

    public V get(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity<K, V>> entities = list.get(hash);
        for(Entity<K, V> entity : entities) {
            if(entity.key.equals(key)) {
                return entity.value;
            }
        }

        return null;
    }

    public V remove(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity<K, V>> entities = list.get(hash);

        for(Entity<K, V> entity : entities) {
            if(entity.key.equals(key)) {
                entities.remove(entity);
                size--;
                return entity.value;
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity<K, V>> entities = list.get(hash);

        for(Entity<K, V> entity : entities) {
            if(entity.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(LinkedList<Entity<K, V>> entities : list) {
            for(Entity<K, V> entity : entities) {
                builder.append(entity.key);
                builder.append(" = ");
                builder.append(entity.value);
                builder.append(", ");
            }
        }
        if(builder.length() > 1) {
            builder.delete(builder.length() - 2, builder.length());
        }

        builder.append("}");

        return builder.toString();
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> ages = new CustomHashMap<>();
        ages.put("Jawahir", 15);
        ages.put("Kamal", 18);
        ages.put("John", 21);
        System.out.println(ages);
        ages.remove("Kamal");
        System.out.println(ages);
    }
}
