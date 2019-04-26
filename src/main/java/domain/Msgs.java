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
	PrintTotalPrice_1("원입니다.\n 예매를 완료했습니다. 즐거운 영화 관람되세요.");
	
	
	String msg = "";
	Msgs(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		return msg; 
	}
}
