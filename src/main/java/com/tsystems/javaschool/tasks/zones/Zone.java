package com.tsystems.javaschool.tasks.zones;

import java.util.List;

public class Zone {

    private final Integer id;

    private final List<Integer> neighbours;

    public Zone(Integer id, List<Integer> neighbours) {
        this.id = id;
        this.neighbours = neighbours;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getNeighbours() {
        return neighbours;
    }
}
