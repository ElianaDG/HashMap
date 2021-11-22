import java.util.*;

public class OurHashMap<K,V> implements Map<K,V> {

    private final int SIZE = 16;

    class Entry<K,V> {
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    List<Entry> values[] = new List[SIZE];
    //each index in values contains a list of entries

    @Override
    public int size() {
        int size = 0;
        for(List<Entry> list : values){
            if(!(list == null)){
                size += list.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        for(List<Entry> list : values){
            if(!(list == null)){
                if(!list.isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if(list == null){
            return false;
        }
        for(Entry entry : list){
            if(entry.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(List<Entry> list : values){
            if(!(list == null)){
                for(Entry entry : list){
                    if(entry.value.equals(value)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if(list == null){
            return null;
        }
        for(Entry entry : list){
            if(entry.key.equals(key)){
                return (V) entry.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List list = values[index];
        if(list == null){
            list = new ArrayList<Entry>();
            values[index] = list;
        }
        for(Entry<K,V> entry : (List<Entry<K,V>>) list){
            if(entry.key.equals(key)) {
                V saved = entry.value;
                entry.value = value;
                return saved;
            }
        }

        Entry entry = new Entry(key, value);
        list.add(entry);
        return null;
    }

    @Override
    public V remove(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if(!(list == null)){
            for(Entry entry : list){
                if(entry.key.equals(key)){
                    V value = (V) entry.value;
                    list.remove(entry);
                    return value;
                }
            }
        }
        return null;
    }

    @Override
    public void putAll(Map map) {
        //use methods to get all the values
        //add them to my values array
    }

    @Override
    public void clear() {
        for(List<Entry> list : values){
            if(!(list == null)){
                list.clear();
            }
        }

    }

    @Override
    public Set keySet() {
        Set keys = new HashSet();
        for(List<Entry> list : values){
            if(!(list == null)){
                for(Entry entry : list){
                    keys.add(entry.key);
                }
            }
        }
        return keys;
    }

    @Override
    public Collection values() {
        Collection mapValues = new HashSet();
        for(List<Entry> list : values){
            if(!(list == null)){
                for(Entry entry : list){
                    mapValues.add(entry.value);
                }
            }
        }
        return mapValues;
    }

    @Override
    public Set<java.util.Map.Entry<K,V>> entrySet() {
        return null;
    }
}
