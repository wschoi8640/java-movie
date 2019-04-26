package domain;

import java.util.ArrayList;
import java.util.List;

public class Model {
	 private Movie movie;
	 private PlaySchedule schedule;
	 private int ticketNum;
	 private Ticket ticket;
	 private int point = 0;
	 private int creditOrCash;
	 private List<Movie> movies;
	 private List<PlaySchedule> schedules;
	 private List<Ticket> cart = new ArrayList<Ticket>();
	 
	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<PlaySchedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<PlaySchedule> schedules) {
		this.schedules = schedules;
	}

	public PlaySchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(PlaySchedule schedule) {
		this.schedule = schedule;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void addTicketsToCart() {
		getCart().add(ticket);
		for(int i = 0; i < movies.size(); i++) {
			if(movies.get(i).getId() == ticket.getId()) {
				for(int j = 0; j < movies.get(i).getPlaySchedules().size(); j++) {
					if(movies.get(i).getPlaySchedules().get(j) == ticket.getSchedule()) {
						movies.get(i).getPlaySchedules().get(j).modifyCapacity(ticket.getTicketNum());
					}
				}
			}
		}
	}

	public List<Ticket> getCart() {
		return cart;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getCreditOrCash() {
		return creditOrCash;
	}

	public void setCreditOrCash(int creditOrCash) {
		this.creditOrCash = creditOrCash;
	}

}
