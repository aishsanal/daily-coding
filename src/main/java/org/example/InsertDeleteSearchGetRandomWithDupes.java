package org.example;

import java.util.*;

public class InsertDeleteSearchGetRandomWithDupes {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand = new Random();

    public InsertDeleteSearchGetRandomWithDupes() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();

    }

    public boolean insert(int val) {
        list.add(val);
        int index = list.size() - 1;

        map.computeIfAbsent(val, k -> new LinkedHashSet<>());
        map.get(val).add(index);
        return true;
    }

    public boolean remove(int val) {
        if(map.get(val) != null) {
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);

            int last = list.size() - 1;
            int lastNum = list.get(last);
            if(index != last) {
                Collections.swap(list, index, last);
                map.get(lastNum).remove(last);
                map.get(lastNum).add(index);
            }
            list.remove(last);
            if (map.get(lastNum).isEmpty())
                map.remove(lastNum);
            return true;
        }
        return false;
    }

    public int getRandom() {
        //int randIndex = (int) (Math.random() * list.size());
        return list.get(rand.nextInt(list.size()));
    }
}
