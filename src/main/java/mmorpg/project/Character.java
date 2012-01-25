package mmorpg.project;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Character {

	public String name;
	public JobClass jobClass;
	public int level;
	
	public String jobClassString;

	public Character(String name, JobClass jobClass, int level) {
		this.name = name;
		this.jobClass = jobClass;
		this.level = level;

		this.jobClassString = jobClassString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JobClass getJobClass() {
		return jobClass;
	}

	public void setJobClass(JobClass jobClass) {
		this.jobClass = jobClass;
	}

	@Min(0)
	@Max(99)
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


	public String getJobClassString() {
		return jobClassString;
	}

	public void setJobClassString(String jobClassString) {
		this.jobClassString = jobClassString;
	}

}
