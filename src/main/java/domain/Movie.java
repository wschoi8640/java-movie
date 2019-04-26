package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        getPlaySchedules().add(playSchedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : getPlaySchedules()) {
            sb.append(playSchedule);
        }
        return getId() + " - " + getName() + ", " + getPrice() + "원" + NEW_LINE
                + sb.toString();
    }

	public int getId() {
		return id;
	}

	public List<PlaySchedule> getPlaySchedules() {
		return playSchedules;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
    
}
