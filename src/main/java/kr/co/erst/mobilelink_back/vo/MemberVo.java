package kr.co.erst.mobilelink_back.vo;

import javax.validation.constraints.*;
import java.util.Date;

public class MemberVo {
    private int id; // 순서번호
    @NotBlank(message = "이름을 작성해주세요.")
    private String name; // 이름
    @NotBlank(message = "아이디를 작성해주세요.")
    private String login; // 로그인아이디
    @NotBlank(message = "비밀번호를 작성해주세요.")
    private String password; // 비밀번호
    @Pattern(regexp = "^010-[0-9]{4}-[0-9]{4}$", message = "전화번호 양식이 일치하지 않습니다.")
    private String phonenumber; // 전화번호
    private int telecom; // 회원분류 (1. 일반회원, 2. 사업자회원)
    private Date createdDate; // 가입날짜
    private Date updatedDate; // 갱신날짜
    private int status; // 회원 상태

    public MemberVo() {}
    public MemberVo(String name, String login, String password, String phonenumber, int telecom) {
        this(0, name, login, password, phonenumber, telecom, null, null, 1);
    }
    public MemberVo(int id, String name, String login, String password, String phonenumber, int telecom, Date createdDate, Date updatedDate, int status) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.phonenumber = phonenumber;
        this.telecom = telecom;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getTelecom() {
        return telecom;
    }

    public void setTelecom(int telecom) {
        this.telecom = telecom;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MemberVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", telecom=" + telecom +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", status=" + status +
                '}';
    }

}
