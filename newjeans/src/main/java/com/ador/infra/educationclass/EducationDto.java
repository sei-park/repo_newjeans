package com.ador.infra.educationclass;

import java.util.Date;

public class EducationDto {
	
	private String seq;
	private String educationType;
	private String educationName;
	private String educationExpenses;
	private String teacher;
	private String courseRegStart;
	private String courseRegEnd;
	private String studyStart;
	private String studtEnd;
	private String educationPlace;
	private String educationContent;
	private Date regDate;
	private Date revDate;
	//-----
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getEducationType() {
		return educationType;
	}
	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}
	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	public String getEducationExpenses() {
		return educationExpenses;
	}
	public void setEducationExpenses(String educationExpenses) {
		this.educationExpenses = educationExpenses;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCourseRegStart() {
		return courseRegStart;
	}
	public void setCourseRegStart(String courseRegStart) {
		this.courseRegStart = courseRegStart;
	}
	public String getCourseRegEnd() {
		return courseRegEnd;
	}
	public void setCourseRegEnd(String courseRegEnd) {
		this.courseRegEnd = courseRegEnd;
	}
	public String getStudyStart() {
		return studyStart;
	}
	public void setStudyStart(String studyStart) {
		this.studyStart = studyStart;
	}
	public String getStudtEnd() {
		return studtEnd;
	}
	public void setStudtEnd(String studtEnd) {
		this.studtEnd = studtEnd;
	}
	public String getEducationPlace() {
		return educationPlace;
	}
	public void setEducationPlace(String educationPlace) {
		this.educationPlace = educationPlace;
	}
	public String getEducationContent() {
		return educationContent;
	}
	public void setEducationContent(String educationContent) {
		this.educationContent = educationContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getRevDate() {
		return revDate;
	}
	public void setRevDate(Date revDate) {
		this.revDate = revDate;
	}
	
	

}
