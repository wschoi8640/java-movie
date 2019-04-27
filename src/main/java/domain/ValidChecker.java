package domain;

import java.util.List;

import utils.DateTimeUtils;
/**
 * 입력값의 유효성을 검사하는 클래스
 * 
 * @author wschoi8640
 * @version 1.1
 */
public class ValidChecker {

	static Model model;
	static boolean isValid = false;
	
	public ValidChecker(Model model) {
		this.model = model;
	}

	/**
	 * 입력한 영화가 존재하는지 유효성 검사 
	 * 
	 * @param movieId
	 * @return isValid
	 */
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

	/**
	 * 선택된 시간표가 존재하는지 ,
	 * 일행과 시간차가 1시간 이내인지 유효성 검사
	 * 
	 * @param scheduleNum
	 * @return isValid
	 */
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

	/**
	 * 해당 인원만큼 해당 시간표의 영화가 유효한지 검사 
	 * 
	 * @param ticketNum
	 * @return isValid
	 */
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

	/**
	 * 입력된 값의 유효성 검사 
	 * 
	 * @param isContinue
	 * @return isValid
	 */
	public static boolean isValidIsContinue(int isContinue) {
		isValid = false;
		if(isContinue == 1 || isContinue == 2) {
			isValid = true;
		}
		if(!isValid) System.out.println("1 또는 2 를 입력해야 합니다.");
		return isValid;
	}

	/**
	 * 사용 포인트가 유효한지 검사
	 * 
	 * @param point
	 * @return isValid
	 */
	public static boolean isValidPoint(int point) {
		isValid = true;
		if(point < 0) {
			isValid = false;
		}
		if(!isValid) System.out.println("포인트는 0 이상 입력해야 합니다.");
		return isValid;
	}

	/**
	 * 입력한 선택지가 유효한지 검사 
	 * 
	 * @param creditOrCash
	 * @return isValid
	 */
	public static boolean isValidCreditOrCash(int creditOrCash) {
		isValid = false;
		if(creditOrCash == 1 || creditOrCash == 2) {
			isValid = true;
		}
		if(!isValid) System.out.println("1 또는 2 를 입력해야 합니다.");
		return isValid;
	}
}