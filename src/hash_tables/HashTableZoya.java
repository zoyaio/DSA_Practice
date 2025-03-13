package hash_tables;

import java.util.*;

public class HashTableZoya implements Map {
    private ArrayList<LinkedList<Object>> table;

    public HashTableZoya() {
        table = new ArrayList<>();
    }
    // hashing
    private int generateHashCode(Object obj) {
        int hashCode = obj.hashCode();
        return (hashCode * 2 + 53 * (hashCode % 27)) % getNumBuckets();
    }
    private int getNumBuckets() {
        return table.size();
    }
    @Override
    public int size() {
        int sumSize = 0;
        for (int i = 0; i < table.size(); i ++) {
            sumSize += table.get(i).size();
        }
        return sumSize;
    }

    @Override
    public boolean isEmpty() {
        int totalYeses = 0;
        for (int i = 0; i < table.size(); i++) {
            LinkedList ith = table.get(i);
            if (ith != null) {
                totalYeses += ith.isEmpty() ? 1 :0;
            }
            else {
                totalYeses ++;
            }

        }
        return totalYeses == table.size();
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        // search
        for (int i = 0; i < table.size(); i ++) {
            LinkedList<Object> ith = table.get(i);
            if (ith != null && ith.contains(value)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
        //andle collisions
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

}
