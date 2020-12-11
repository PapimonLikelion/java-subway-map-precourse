package subway.domain;

import java.util.ArrayList;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private ArrayList<Station> stationsInLine = new ArrayList<Station>();

    public void addStationsInLine(Station station) {
        stationsInLine.add(station);
    }
}
