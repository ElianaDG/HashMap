import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest {

    @Test
    public void put(){
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
    public void get(){
        //given
        OurHashMap map = new OurHashMap();

        //when

        //then
        assertNull(map.get("English1"));

    }

}