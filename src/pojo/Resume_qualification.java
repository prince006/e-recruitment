/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author The Developer <Developer at APIIT>
 */
public class Resume_qualification {

    private Integer resume_qualification_no;
    private Resume resume;
    private String qualification;
    private Integer pass_year;
    private String board_university;
    private Double percentage;
    private String grade;

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public String getBoard_university() {
        return board_university;
    }

    public void setBoard_university(String board_university) {
        this.board_university = board_university;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getPass_year() {
        return pass_year;
    }

    public void setPass_year(Integer pass_year) {
        this.pass_year = pass_year;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Integer getResume_qualification_no() {
        return resume_qualification_no;
    }

    public void setResume_qualification_no(Integer resume_qualification_no) {
        this.resume_qualification_no = resume_qualification_no;
    }
}
