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
