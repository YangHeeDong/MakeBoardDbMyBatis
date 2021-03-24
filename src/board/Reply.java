package board;
import lombok.Data;

@Data
public class Reply {
	
	private int id;
	private int aid;
	private String body;
	private int mid;
	private String regDate;
	private String nickname;
	
}

