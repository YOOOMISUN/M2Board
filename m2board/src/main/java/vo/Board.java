package vo;

public class Board {
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private String creatDate;
	private String read;
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}

	
	public Board() {
		super();
	}
	public Board(int boardNo, String title, String writer, String content, String creatDate, String read, int nice) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.creatDate = creatDate;
		this.read = read;
	}
	
	
	
	
	
	
}
