package domain;

import java.util.List;

import utils.DateTimeUtils;

public class ValidChecker {

	static Model model;
	static boolean isValid = false;
	
	public ValidChecker(Model model) {
		this.model = model;
	}

	public static boolean isValidMovieId(int movieId) {
		isValid = false;
		List<Movie> movies = model.getMovies();
		for(Movie movie : movies) {
			if(movie.getId() == movieId) {
				isValid = true;
			}
		}
		return isValid;
	}

	public static boolean isValidSchedule(int scheduleNum) {
		List<PlaySchedule> schedules = model.getSchedules();
		if(schedules.size() < scheduleNum || scheduleNum <= 0) {
			return false;
		}
		PlaySchedule schedule = schedules.get(scheduleNum - 1);
		if(schedule.getCapacity() == 0) {
			return false;
		}
		List<Ticket> cart = model.getCart();
		for(Ticket ticket : cart) {
			if(!DateTimeUtils.isOneHourWithinRange(ticket.getSchedule().getStartDateTime(), schedule.getStartDateTime())) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidTicketNum(int ticketNum) {
		isValid = true;
		if(ticketNum > model.getSchedule().getCapacity()) {
			isValid = false;
		}
		if(ticketNum <= 0) {
			isValid = false;
		}
		return isValid;
	}
}