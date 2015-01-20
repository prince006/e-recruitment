/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;

/**
 *
 * @author The Developer <Developer at APIIT>
 */
public class Resume_Experience {

    private Integer resume_exp_no;
    private Resume resume;
    private String job_title;
    private String job_profile;
    private String company;
    private String location;
    private String job_responsibility;
    private String from_date;
    private String to_date;

 
	public Resume_Experience() {
		
	}

	public Resume_Experience(String job_title, String job_profile,
			String job_responsibility, String company, String location,
			String from_date, String to_date, Resume resume) {		
		this.job_title = job_title;
		this.job_profile = job_profile;
		this.job_responsibility = job_responsibility;
		this.company = company;
		this.location = location;
		this.from_date = from_date;
		this.to_date = to_date;
		this.resume = resume;
	}
	

	public Resume_Experience(Integer resume_exp_no, String job_title,
			String job_profile, String job_responsibility, String company,
			String location, String from_date, String to_date, Resume resume) {
		super();
		this.resume_exp_no = resume_exp_no;
		this.job_title = job_title;
		this.job_profile = job_profile;
		this.job_responsibility = job_responsibility;
		this.company = company;
		this.location = location;
		this.from_date = from_date;
		this.to_date = to_date;
		this.resume = resume;
	}

	public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
   
    public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public String getJob_responsibility() {
        return job_responsibility;
    }

    public void setJob_responsibility(String job_responsibility) {
        this.job_responsibility = job_responsibility;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getJob_profile() {
        return job_profile;
    }

    public void setJob_profile(String job_profile) {
        this.job_profile = job_profile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

  
    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Integer getResume_exp_no() {
        return resume_exp_no;
    }

    public void setResume_exp_no(Integer resume_exp_no) {
        this.resume_exp_no = resume_exp_no;
    }

	public String getTo_date() {
		return to_date;
	}

    


}
