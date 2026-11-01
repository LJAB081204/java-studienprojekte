package com.mycompany.praktikum2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class PM2MapTest {

    private PM2Map<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new PM2Map<>();
    }

    @Test
    void testEmptySize() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    void testPutAndGet() {
        assertNull(map.put("one", 1));
        assertEquals(1, map.get("one"));
        assertEquals(1, map.size());

        assertEquals(1, map.put("one", 11)); // update
        assertEquals(11, map.get("one"));
        assertEquals(1, map.size()); // Größe bleibt gleich
    }

    @Test
    void testContainsKeyAndValue() {
        map.put("a", 10);
        map.put("b", 20);
        assertTrue(map.containsKey("a"));
        assertTrue(map.containsValue(20));
        assertFalse(map.containsKey("x"));
        assertFalse(map.containsValue(99));
    }

    @Test
    void testRemove() {
        map.put("a", 100);
        map.put("b", 200);

        Integer removed = map.remove("a");
        assertEquals(100, removed);
        assertNull(map.get("a"));
        assertEquals(1, map.size());

        assertNull(map.remove("not-exist"));
    }

    @Test
    void testPutAll() {
        Map<String, Integer> other = Map.of("x", 1, "y", 2);
        map.putAll(other);

        assertEquals(2, map.size());
        assertEquals(1, map.get("x"));
        assertEquals(2, map.get("y"));
    }

    @Test
    void testClear() {
        map.put("key", 5);
        map.clear();
        assertTrue(map.isEmpty());
        assertNull(map.get("key"));
    }

    @Test
    void testKeySet() {
        map.put("k1", 1);
        map.put("k2", 2);
        Set<String> keys = map.keySet();
        assertEquals(2, keys.size());
        assertTrue(keys.contains("k1"));
        assertTrue(keys.contains("k2"));
    }

    @Test
    void testValues() {
        map.put("a", 10);
        map.put("b", 20);
        Collection<Integer> values = map.values();

        assertEquals(2, values.size());
        assertTrue(values.contains(10));
        assertTrue(values.contains(20));
    }

    @Test
    void testEntrySet() {
        map.put("a", 1);
        map.put("b", 2);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        assertEquals(2, entries.size());

        for (Map.Entry<String, Integer> entry : entries) {
            assertEquals(map.get(entry.getKey()), entry.getValue());
        }

        // Test presence of specific entry
        assertTrue(entries.contains(new MapPaar<>("a", 1)));
        assertFalse(entries.contains(new MapPaar<>("a", 999)));
    }
}
