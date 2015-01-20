/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author The Developer <Developer at APIIT>
 */
public class Resume {

    private Integer resume_no;
    private String title;
    private String first_name;
    private String last_name;
    private String c_address;
    private String p_address;
    private String mobile_no;
    private String email;
    private String gender;
    private String is_married;
    private String remarks;
    private String skills;
    private Double rating;
    private Double exp;
    private String is_active;
    private String created_by;
    private Timestamp created_on;

    
    public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Resume() {
    	created_on= new Timestamp(System.currentTimeMillis());
	}
    
	public Double getExp() {
		return exp;
	}

	public void setExp(Double exp) {
		this.exp = exp;
	}

	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
  
    public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getIs_married() {
        return is_married;
    }

    public void setIs_married(String is_married) {
        this.is_married = is_married;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getResume_no() {
        return resume_no;
    }

    public void setResume_no(Integer resume_no) {
        this.resume_no = resume_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
