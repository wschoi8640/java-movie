package domain;
/**
 * 사용자가 선택한 영화와 관련된 정보, 메소드를 가진 클래스
 * 
 * @author wschoi8640
 * @version 1.0
 */
public class Ticket {
    private static final char NEW_LINE = '\n';

    private final int id;
	private final String name;
	private final int price;
	private final PlaySchedule schedule;
	private final int ticketNum;
	
	public Ticket(Movie movie, PlaySchedule schedule, int ticketNum) {
		this.id = movie.getId();
		this.name = movie.getName();
		this.price = movie.getPrice();
		this.schedule = schedule;
		this.ticketNum = ticketNum;
	}
	
    @Override
    public String toString() {
        return getId() + " - " + getName() + ", " + getPrice() + NEW_LINE + getSchedule() 
                + "예약 인원 : " + getTicketNum() + "명" + NEW_LINE;
    }

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public PlaySchedule getSchedule() {
		return schedule;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public int getId() {
		return id;
	}
}
