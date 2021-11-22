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
            if(list != null){
                size += list.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        for(List<Entry> list : values){
            if(list != null){
                if(!list.isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        List<Entry> list = getEntries(key);
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
            if(list != null){
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
        List<Entry> list = getEntries(key);
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

    private List<Entry> getEntries(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        return values[index];
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
        if(list != null){
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
        Set<K> keys = map.keySet();
        for(K key : keys){
            V value = (V) map.get(key);
            this.put(key, value);
        }
    }

    @Override
    public void clear() {
        for(List<Entry> list : values){
            if(list != null){
                list.clear();
            }
        }

    }

    @Override
    public Set keySet() {
        Set<K> keys = new HashSet();
        for(List<Entry> list : values){
            if(list != null){
                for(Entry entry : list){
                    keys.add((K) entry.key);
                }
            }
        }
        return keys;
    }

    @Override
    public Collection values() {
        Collection<V> mapValues = new HashSet();
        for(List<Entry> list : values){
            if(list != null){
                for(Entry entry : list){
                    mapValues.add((V) entry.value);
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
