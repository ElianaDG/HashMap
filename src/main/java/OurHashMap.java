import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class OurHashMap implements Map {

    private final int SIZE = 1024;
    Object values[] = new Object[SIZE];

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        return values[index];
    }

    @Override
    public Object put(Object key, Object value) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        values[index] = value;
        // todo return previous value
        return null;
    }

    @Override
    public Object remove(Object o) {
        return null;
    }

    @Override
    public void putAll(Map map) {

    }

    @Override
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
