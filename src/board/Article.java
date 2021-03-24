package board;
import lombok.Data;

@Data
public class Article {
	
	private int id; 
	private String title;
	private String body;  
	private String regDate;
	private int mid;
	private String nickname;

}