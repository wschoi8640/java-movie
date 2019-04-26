package view;

import domain.Movie;
import domain.PlaySchedule;
import domain.Ticket;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie.toString());
        }
    }
    
    public static void printSchedules(List<PlaySchedule> schedules) {
    	for (PlaySchedule schedule : schedules) {
    		System.out.print(schedule.toString());
    	}
    }

	public static void printTicketsAtCart(List<Ticket> cart) {
		for(Ticket ticket : cart) {
			System.out.println(ticket.toString());
		}
	}

	public static void printTotalPrice(int total) {
		System.out.println("최종 결제한 금액은" + total + "원입니다.");
		System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
	}
}
