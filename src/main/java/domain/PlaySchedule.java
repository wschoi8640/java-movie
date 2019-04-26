package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;
/**
 * 영화 스케쥴과 관련된 정보, 메소드를 가진 클래스
 * 
 * @author wschoi8640
 * @version 1.0
 */
public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.setCapacity(capacity);
    }

    @Override
    public String toString() {
        return "시작시간: " + format(getStartDateTime()) + " 예약가능인원: " + getCapacity() + "\n";
    }
    
    public void modifyCapacity(int ticketNum) {
    	setCapacity(getCapacity() - ticketNum);
    }

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
