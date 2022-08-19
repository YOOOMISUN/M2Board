package vo;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String creatDate;
	private String boardRead;
	private String boardNice;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	public String getBoardRead() {
		return boardRead;
	}
	public void setBoardRead(String boardRead) {
		this.boardRead = boardRead;
	}
	public String getBoardNice() {
		return boardNice;
	}
	public void setBoardNice(String boardNice) {
		this.boardNice = boardNice;
	}
	
	
	public Board() {
		super();

	}
	public Board(int boardNo, String boardTitle, String boardWriter, String boardContent, String creatDate,
			String boardRead, String boardNice) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.creatDate = creatDate;
		this.boardRead = boardRead;
		this.boardNice = boardNice;
	}
	
	
	
	
	
}
