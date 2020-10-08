package fr.insa.msa.StudentEvalService.model;

public class Evaluation {

	private int idStudent;
	private float average;
	
	public Evaluation(int i, float f) {
		this.idStudent = i;
		this.average = f;
	}

	public int getIdStudent() {
		return idStudent;
	}
	
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	public float getAverage() {
		return average;
	}
	
	public void setAverage(float average) {
		this.average = average;
	}
}
