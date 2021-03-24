package board;
import lombok.Data;

@Data
public class Member {
	private int id;
	private String loginId;
	private String nickname;
	private String loginPw;
}
