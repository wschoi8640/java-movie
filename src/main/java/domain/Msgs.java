package domain;

/**
 * 메시지 상수를 보관하는 Enum 클래스
 * 
 * @author wschoi8640
 * @version 1.1
 */
public enum Msgs {
	
	MovieIdReceive("## 예약할 영화를 선택하세요."),
	MovieScheduleReceive("## 예약할 시간표를 선택하세요."),
	TicketNumReceive("## 예약할 인원을 입력하세요."),
	IsContinueReceive("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번"),
	ProcessResult("## 결제를 진행합니다."),
	PointReceive("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력"),
	CreditOrCashReceive("## 신용카드는 1번, 현금은 2번"),
	PrintTotalPrice_0("최종 결제한 금액은"),
	PrintTotalPrice_1("원입니다.\n 예매를 완료했습니다. 즐거운 영화 관람되세요."),
	InputTypeErr("잘못된 입력입니다."),
	NoMatchMovieErr("일치하는 영화가 없습니다."),
	ScheduleNotExistErr("해당 시간대가 존재하지 않습니다."),
	NoSeatAvailErr("남는 자리가 업습니다."),
	GroupTimeErr("일행과 1시간 이상 차이납니다."),
	NotEnoughSeatErr("자리가 부족합니다.");
	
	
	String msg = "";
	Msgs(String msg){
		this.msg = msg;
	}
	/**
	 * 해당 메세지를 반환하는 메소드
	 * 
	 * @return 선택된 메시지
	 */
	public String getMsg(){
		return msg; 
	}
}
