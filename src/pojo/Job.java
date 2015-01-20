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
public class Job {

	private Integer job_no;
	private String title;
	private String description;
	private Double min_exp;
	private Double max_exp;
	private Date expire_date;
	private String skill_req;
	private String location;
	private String job_role;
	private String emp_type;
	private String fun_area;
	private String job_cat;
	private String is_active;
	
	public String getSkill_req() {
		return skill_req;
	}

	public void setSkill_req(String skill_req) {
		this.skill_req = skill_req;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJob_role() {
		return job_role;
	}

	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	public String getFun_area() {
		return fun_area;
	}

	public void setFun_area(String fun_area) {
		this.fun_area = fun_area;
	}

	public String getJob_cat() {
		return job_cat;
	}

	public void setJob_cat(String job_cat) {
		this.job_cat = job_cat;
	}

	private String created_by;
	private Timestamp created_on;
	private Set<UserPojo> applicants;
	private Set<UserPojo> saveJob;

	
	
	public Set<UserPojo> getSaveJob() {
		return saveJob;
	}

	public void setSaveJob(Set<UserPojo> saveJob) {
		this.saveJob = saveJob;
	}

	public Set<UserPojo> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<UserPojo> applicants) {
		this.applicants = applicants;
	}

	public Job() {
		created_on = new Timestamp(System.currentTimeMillis());
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public Integer getJob_no() {
		return job_no;
	}

	public void setJob_no(Integer job_no) {
		this.job_no = job_no;
	}

	public Double getMax_exp() {
		return max_exp;
	}

	public void setMax_exp(Double max_exp) {
		this.max_exp = max_exp;
	}

	public Double getMin_exp() {
		return min_exp;
	}

	public void setMin_exp(Double min_exp) {
		this.min_exp = min_exp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
