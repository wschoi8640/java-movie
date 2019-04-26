package domain;

import java.util.List;

import utils.DateTimeUtils;
/**
 * 입력값의 유효성을 검사하는 클래스
 * 
 * @author wschoi8640
 * @version 1.0
 */
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
		if(!isValid) System.out.println(Msgs.NoMatchMovieErr.getMsg());
		return isValid;
	}

	public static boolean isValidSchedule(int scheduleNum) {
		List<PlaySchedule> schedules = model.getSchedules();
		if(schedules.size() < scheduleNum || scheduleNum <= 0) {
			System.out.println(Msgs.ScheduleNotExistErr.getMsg());
			return false;
		}
		PlaySchedule schedule = schedules.get(scheduleNum - 1);
		if(schedule.getCapacity() == 0) {
			System.out.println(Msgs.NoSeatAvailErr.getMsg());
			return false;
		}
		List<Ticket> cart = model.getCart();
		for(Ticket ticket : cart) {
			if(!DateTimeUtils.isOneHourWithinRange(ticket.getSchedule().getStartDateTime(), schedule.getStartDateTime())) {
				System.out.println(Msgs.GroupTimeErr.getMsg());
				return false;
			}
		}
		return true;
	}

	public static boolean isValidTicketNum(int ticketNum) {
		isValid = true;
		if(ticketNum > model.getSchedule().getCapacity()) {
			System.out.println(Msgs.NotEnoughSeatErr.getMsg());
			isValid = false;
		}
		if(ticketNum <= 0) {
			System.out.println("1표 이상 예약해야 합니다.");
			isValid = false;
		}
		return isValid;
	}

	public static boolean isValidIsContinue(int isContinue) {
		isValid = false;
		if(isContinue == 1 || isContinue == 2) {
			isValid = true;
		}
		if(!isValid) System.out.println("1 또는 2 를 입력해야 합니다.");
		return isValid;
	}

	public static boolean isValidPoint(int point) {
		isValid = true;
		if(point < 0) {
			isValid = false;
		}
		if(!isValid) System.out.println("포인트는 0 이상 입력해야 합니다.");
		return isValid;
	}

	public static boolean isValidCreditOrCash(int creditOrCash) {
		isValid = false;
		if(creditOrCash == 1 || creditOrCash == 2) {
			isValid = true;
		}
		if(!isValid) System.out.println("1 또는 2 를 입력해야 합니다.");
		return isValid;
	}
}