import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest {

    @Test
    void put(){
        //given
        OurHashMap map = new OurHashMap<String, String>();

        //when
        map.put("English1","Hello");
        map.put("English2","Hi");
        map.put("English3","Hey");
        map.put("Spanish","Hola");
        map.put("Hebrew","Shalom");
        map.put("French","Bonjour");
        map.put("Russian","Priviyet");
        map.put("Japanese","Conichiwa");
        map.put("Mandarin","Ne How");

        //then
        assertEquals("Hello", map.get("English1"));
        assertEquals("Hi", map.get("English2"));
        assertEquals("Hey", map.get("English3"));
        assertEquals("Hola", map.get("Spanish"));
        assertEquals("Shalom", map.get("Hebrew"));
        assertEquals("Bonjour", map.get("French"));
        assertEquals("Priviyet", map.get("Russian"));
        assertEquals("Conichiwa", map.get("Japanese"));
        assertEquals("Ne How", map.get("Mandarin"));
    }

    @Test
    void get(){
        //given
        OurHashMap<String,String> map = new OurHashMap<>();

        //when

        //then
        assertNull(map.get("English1"));

    }

    @Test
    void putSameKeys(){
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("English1", "Hello");
        map.put("Spanish", "Hola");
        map.put("Hebrew", "Shalom");
        map.put("French", "Bonjour");
        map.put("English1", "Hi");

        // then
        assertEquals("Hi", map.get("English1"));
    }

    @Test
    void size(){
        //given
        OurHashMap map = new OurHashMap<String, String>();

        //when
        map.put("English1","Hello");
        map.put("English2","Hi");
        map.put("English3","Hey");
        map.put("Spanish","Hola");
        map.put("Hebrew","Shalom");
        map.put("French","Bonjour");
        map.put("Russian","Priviyet");
        map.put("Japanese","Conichiwa");
        map.put("Mandarin","Ne How");

        //then
        Assertions.assertEquals(9, map.size());

    }

    @Test
    void isEmpty(){
        //given
        OurHashMap map = new OurHashMap<String, String>();

        //then
        Assertions.assertTrue(map.isEmpty());
        Assertions.assertEquals(0, map.size());
    }

    @Test
    void isNotEmpty(){
        //given
        OurHashMap map = new OurHashMap<String, String>();
        map.put("Hebrew", "Shalom");

        //then
        Assertions.assertFalse(map.isEmpty());
    }

    @Test
    void containsKey(){
        //given
        OurHashMap map = new OurHashMap<String, String>();
        map.put("Spanish","Hola");
        map.put("Hebrew","Shalom");
        map.put("French","Bonjour");

        //then
        Assertions.assertTrue(map.containsKey("French"));
        Assertions.assertFalse(map.containsKey("German"));

    }

    @Test
    void containsValue(){
        //given
        OurHashMap map = new OurHashMap<String, String>();
        map.put("English1","Hello");
        map.put("English2","Hi");
        map.put("English3","Hey");
        map.put("Spanish","Hola");

        //then
        Assertions.assertTrue(map.containsValue("Hello"));
        Assertions.assertFalse(map.containsValue("Shalom"));

    }

    @Test
    void remove(){
        //given
        OurHashMap map = new OurHashMap<String, String>();
        map.put("English1","Hello");
        map.put("English2","Hi");
        map.put("English3","Hey");

        //when
        Object removed = map.remove("English1");

        //then
        Assertions.assertEquals("Hello", removed);
        Assertions.assertFalse(map.containsValue("Hello"));
    }

    @Test
    void putAll(){
        //given
        HashMap mapA = new HashMap<String, String>();
        OurHashMap mapB = new OurHashMap<String, String>();
        mapA.put("English1","Hello");
        mapA.put("English2","Hi");
        mapA.put("English3","Hey");
        mapA.put("Spanish","Hola");

        //when
        mapB.putAll(mapA);

        //then
        Assertions.assertTrue(mapB.containsKey("English1"));
        Assertions.assertTrue(mapB.containsKey("English2"));
        Assertions.assertTrue(mapB.containsKey("English3"));
        Assertions.assertTrue(mapB.containsKey("Spanish"));
        Assertions.assertEquals(mapA.size(), mapB.size());

    }

    @Test
    void clear(){
        //given
        OurHashMap map = new OurHashMap<String, String>();
        map.put("English1","Hello");
        map.put("English2","Hi");
        map.put("English3","Hey");

        //when
        map.clear();

        //then
        Assertions.assertTrue(map.isEmpty());
        Assertions.assertFalse(map.containsKey("English1"));
    }

    @Test
    void keySet(){
        //given
        OurHashMap map = new OurHashMap<String, String>();
        map.put("English1","Hello");
        map.put("English2","Hi");
        map.put("English3","Hey");

        //when
        Set actualSet = map.keySet();
        Set expectedSet = new HashSet();
        expectedSet.add("English1");
        expectedSet.add("English2");
        expectedSet.add("English3");

        //then
        Assertions.assertEquals(expectedSet, actualSet);

    }

    @Test
    void values(){
        //given
        OurHashMap map = new OurHashMap<String, String>();
        map.put("English1","Hello");
        map.put("English2","Hi");
        map.put("English3","Hey");

        //when
        Collection actual = map.values();
        Collection expected = new HashSet();
        expected.add("Hello");
        expected.add("Hi");
        expected.add("Hey");

        //then
        Assertions.assertEquals(expected, actual);
    }
}