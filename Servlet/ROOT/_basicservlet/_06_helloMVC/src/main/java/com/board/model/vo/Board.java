package com.board.model.vo;

import java.util.Date;

public class Board {
    private int boardNo;
    private String boardTitle;
    private String boardWriter;
    private String boardContent;
    private String boardOriginFileName;
    private String boardRenameFileName;
    private Date boardDate;
    private int boardRecount;

    public Board(int boardNo, String boardTitle, String boardWriter, String boardContent, String boardOriginFileName, String boardRenameFileName, Date boardDate, int boardRecount) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContent = boardContent;
        this.boardOriginFileName = boardOriginFileName;
        this.boardRenameFileName = boardRenameFileName;
        this.boardDate = boardDate;
        this.boardRecount = boardRecount;
    }

    public Board() {
    }

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

    public String getBoardOriginFileName() {
        return boardOriginFileName;
    }

    public void setBoardOriginFileName(String boardOriginFileName) {
        this.boardOriginFileName = boardOriginFileName;
    }

    public String getBoardRenameFileName() {
        return boardRenameFileName;
    }

    public void setBoardRenameFileName(String boardRenameFileName) {
        this.boardRenameFileName = boardRenameFileName;
    }

    public Date getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(Date boardDate) {
        this.boardDate = boardDate;
    }

    public int getBoardRecount() {
        return boardRecount;
    }

    public void setBoardRecount(int boardRecount) {
        this.boardRecount = boardRecount;
    }
}

