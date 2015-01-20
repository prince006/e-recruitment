/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 *
 * @author The Developer <Developer at APIIT>
 */
public class Exam {

    private Integer exam_no;
    private Integer no_of_qus;
    private Integer min_pass;
    private Integer exam_time;
    private String is_active;
    private String created_by;
    private java.sql.Timestamp created_on;
    private Set<Question> questions;
    private Set<UserPojo> takers;
    
	public Exam() {
		created_on= new Timestamp(System.currentTimeMillis());
	}
	
	public Set<UserPojo> getTakers() {
		return takers;
	}

	public void setTakers(Set<UserPojo> takers) {
		this.takers = takers;
	}

	public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }


	public java.sql.Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(java.sql.Timestamp created_on) {
		this.created_on = created_on;
	}

	public Integer getExam_no() {
        return exam_no;
    }

    public void setExam_no(Integer exam_no) {
        this.exam_no = exam_no;
    }

    public Integer getExam_time() {
        return exam_time;
    }

    public void setExam_time(Integer exam_time) {
        this.exam_time = exam_time;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public Integer getMin_pass() {
        return min_pass;
    }

    public void setMin_pass(Integer min_pass) {
        this.min_pass = min_pass;
    }

    public Integer getNo_of_qus() {
        return no_of_qus;
    }

    public void setNo_of_qus(Integer no_of_qus) {
        this.no_of_qus = no_of_qus;
    }
}
