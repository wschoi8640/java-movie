package view;

import domain.Movie;
import domain.Msgs;
import domain.PlaySchedule;
import domain.Ticket;

import java.util.List;
/**
 * 출력하는 메소드들을 가진 클래스
 * 
 * @author wschoi8640
 * @version 1.0
 */
public class OutputView {
	/**
	 * 영화 목록을 출력하는 메소드
	 * 
	 * @param movies
	 */
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie.toString());
        }
    }
    
	/**
	 * 영화 시간표를 출력하는 메소드  
	 * 
	 * @param schedules
	 */
    public static void printSchedules(List<PlaySchedule> schedules) {
    	for (PlaySchedule schedule : schedules) {
    		System.out.print(schedule.toString());
    	}
    }

	/**
	 * 장바구니 내역을 출력하는 메소드
	 * 
	 * @param cart
	 */
	public static void printTicketsAtCart(List<Ticket> cart) {
		for(Ticket ticket : cart) {
			System.out.println(ticket.toString());
		}
	}

	/**
	 * 최종 가격을 출력하는 메소드
	 * 
	 * @param total
	 */
	public static void printTotalPrice(int total) {
		System.out.print(Msgs.PrintTotalPrice_0.getMsg() + total);
		System.out.println(Msgs.PrintTotalPrice_1.getMsg());
	}
}
