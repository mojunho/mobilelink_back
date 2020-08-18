package kr.co.erst.mobilelink_back.vo;

import java.util.Date;

public class BoardVo {
    private int id; // 게시판 순서 번호
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private Date regDate; // 게시글 등록 날짜
    private Date upDate; // 게시글 갱신 날짜
    private int readCount; // 게시글 조회수
    private int telecom; // 게시글 분야(1. SKT, 2. KT, 3. LGT, 4. 유선/인터넷, 5. 생활가전, 6. 이벤트)
    private int adminId; // 게시글 작성자
    private int status; // 게시글 상태

    public BoardVo() {}
    public BoardVo(String title, String content, int telecom, int adminId) {
        this(0, title, content, null, null, 0, telecom, adminId, 1);
    }
    public BoardVo(int id, String title, String content, Date regDate, Date upDate, int readCount, int telecom, int adminId, int status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.upDate = upDate;
        this.readCount = readCount;
        this.telecom = telecom;
        this.adminId = adminId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getTelecom() {
        return telecom;
    }

    public void setTelecom(int telecom) {
        this.telecom = telecom;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BoardVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                ", upDate=" + upDate +
                ", readCount=" + readCount +
                ", telecom=" + telecom +
                ", adminId=" + adminId +
                ", status=" + status +
                '}';
    }

}
