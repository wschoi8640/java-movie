package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import domain.Msgs;
/**
 * 입력 받는 메소드들을 가진 클래스
 * 
 * @author wschoi8640
 * @version 1.0
 */
public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static int result = 0;

	/**
	 * 선택할 영화를 입력받는 메소드 
	 * 
	 * @return movieId
	 */
	public static int inputMovieId() {
		System.out.println(Msgs.MovieIdReceive.getMsg());
		try {
			result = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(Msgs.InputTypeErr.getMsg());
			scanner.next();
			inputMovieId();
		}
		return result;
	}

	/**
	 * 희망하는 시간표를 입력받는 메소드
	 * 
	 * @return scheduleNum
	 */
	public static int inputMovieSchedule() {
		System.out.println(Msgs.MovieScheduleReceive.getMsg());
		try {
			result = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(Msgs.InputTypeErr.getMsg());
			scanner.next();
			inputMovieSchedule();
		}
		return result;
	}

	/**
	 * 관람할 인원을 선택하는 메소드
	 * 
	 * @return ticketNum
	 */
	public static int inputTicketNum() {
		System.out.println(Msgs.TicketNumReceive.getMsg());
		try {
			result = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(Msgs.InputTypeErr.getMsg());
			scanner.next();
			inputTicketNum();
		}
		return result;
	}

	/**
	 * 추가 예매 여부를 입력받는 메소드 
	 * 
	 * @return isContinue
	 */
	public static int inputIsContinue() {
		System.out.println(Msgs.IsContinueReceive.getMsg());
		try {
			result = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(Msgs.InputTypeErr.getMsg());
			scanner.next();
			inputIsContinue();
		}
		return result;
	}

	/**
	 * 사용할 포인트를 입력받는 메소드 
	 * 
	 * @return point
	 */
	public static int inputPoint() {
		System.out.println(Msgs.ProcessResult.getMsg());
		System.out.println(Msgs.PointReceive.getMsg());
		try {
			result = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(Msgs.InputTypeErr.getMsg());
			scanner.next();
			inputPoint();
		}
		return result;
	}

	/**
	 * 지불 수단을 입력받는 메소드
	 * 
	 * @return creditOrCash
	 */
	public static int inputCreditOrCash() {
		System.out.println(Msgs.CreditOrCashReceive.getMsg());
		try {
			result = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(Msgs.InputTypeErr.getMsg());
			scanner.next();
			inputCreditOrCash();
		}
		return result;
	}
}
