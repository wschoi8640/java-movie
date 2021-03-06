import domain.Model;
import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.Ticket;
import domain.ValidChecker;
import view.InputView;
import view.OutputView;

import java.util.List;
/**
 * 영화 예매 프로그램이 진행되는 클래스
 * 
 * @author wschoi8640
 * @version 1.0
 */
public class MovieApplication {
	static Model model;
	static ValidChecker validChecker;
    static int isContinue = 2;

    public static void main(String[] args) {
        model = new Model();
        validChecker = new ValidChecker(model);
    	List<Movie> movies = MovieRepository.getMovies();
        model.setMovies(movies);
        
        while(isContinue == 2) {
            OutputView.printMovies(model.getMovies());
        	chooseMovie();
        	chooseSchedule();
        	chooseTicketNum();
        	addToCart();
        	chooseContinue();
        	if(isContinue == 1) {
        		choosePoint();
        		chooseCreditOrCash();
        		calculateResult();
        	}
        }
    }

    /**
	 * 영화를 선택하는 메소드
	 * 
	 */
	private static void chooseMovie() {
    	int movieId = InputView.inputMovieId();
    	if(!ValidChecker.isValidMovieId(movieId)) {
    		chooseMovie();
    		return;
    	}
		List<PlaySchedule> schedules = null;
        for(Movie movie : model.getMovies()) {
        	if(movie.getId() == movieId){
        		model.setMovie(movie);
        		schedules = movie.getPlaySchedules();
        	}
        }
        OutputView.printSchedules(schedules);
        model.setSchedules(schedules);
    }

	/**
	 * 선택한 영화의 시간표를 선택하는 메소드
	 * 
	 */
    private static void chooseSchedule() {
    	int scheduleNum = InputView.inputMovieSchedule();
    	if(!ValidChecker.isValidSchedule(scheduleNum)) {
    		chooseSchedule();
    		return;
    	}
    	PlaySchedule schedule = model.getSchedules().get(scheduleNum - 1);
    	model.setSchedule(schedule);
	}
    
    /**
	 * 관람할 인원을 정하는 메소드
	 * 
	 */
    private static void chooseTicketNum() {
    	int ticketNum = InputView.inputTicketNum();
    	if(!ValidChecker.isValidTicketNum(ticketNum)) {
    		chooseTicketNum();
    		return;
    	}
    	model.setTicketNum(ticketNum);
    }

    /**
	 * 선택한 내용을 장바구니에 저장하는 메소드
	 * 
	 */
	private static void addToCart() {
		Ticket newTicket = new Ticket(model.getMovie(), model.getSchedule(), model.getTicketNum());
		model.setTicket(newTicket);
		model.addTicketsToCart();
	}
    
	/**
	 * 추가 예매 여부를 선택하는 메소드
	 * 
	 */
    private static void chooseContinue() {
    	 isContinue = InputView.inputIsContinue();
    	 if(!ValidChecker.isValidIsContinue(isContinue)) {
    		 chooseContinue();
     		return;
    	 }
    	 List<Ticket> cart = model.getCart();
    	 OutputView.printTicketsAtCart(cart);
    }
    
    /**
	 * 사용할 포인트를 입력하는 메소드
	 * 
	 */
	private static void choosePoint() {
		int point = InputView.inputPoint();
		if(!ValidChecker.isValidPoint(point)) {
			choosePoint();
    		return;
		}
		model.setPoint(point);
	}

	/**
	 * 지불 수단을 선택하는 메소드
	 * 
	 */
	private static void chooseCreditOrCash() {
		int creditOrCash = InputView.inputCreditOrCash();
		if(!ValidChecker.isValidCreditOrCash(creditOrCash)) {
			chooseCreditOrCash();
    		return;
		}
		model.setCreditOrCash(creditOrCash);
	}
	
	/**
	 * 장바구니에 담긴 내역을 계산하는 메소드
	 * 
	 */
	private static void calculateResult() {
		int total = 0;
		for(Ticket ticket : model.getCart()) {
			total = total + ticket.getPrice() * ticket.getTicketNum();
		}
		if(model.getCreditOrCash() == 1) {
			total = (int)(total * 0.95);
		}
		else if(model.getCreditOrCash() == 2) {
			total = (int)(total * 0.98);
		}
		total = total - model.getPoint();
		if(total <= 0) total = 0;
		OutputView.printTotalPrice(total);
	}
}
