import java.util.Random;
import java.lang.Math;

public class Job {
	private String jobName;
	private int jobLength;
	private int currentJobLength;
	private int jobPriority;
	private int finalPriority;
	private long entryTime;
	private long waitTime;
	private long endTime;
	
	public int numberOfPriorityChanges;
	



	/** parametrized constructor
	 * @param jobName
	 * @param jobLength
	 * @param currentJobLength
	 * @param jobPriority
	 * @param finalPriority
	 * @param entryTime
	 * @param endTime
	 * @param waitTime
	 */
	public Job(String jobName, int jobLength, int currentJobLength, int jobPriority, int finalPriority, long entryTime) {
		this.jobName = jobName;
		this.jobLength = jobLength;
		this.currentJobLength = currentJobLength;
		this.jobPriority = jobPriority;
		this.finalPriority = finalPriority;
		this.entryTime = entryTime;
		
	}


	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}


	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	/**
	 * @return the jobLength
	 */
	public int getJobLength() {
		return jobLength;
	}


	/**
	 * @param jobLength the jobLength to set
	 */
	public void setJobLength(int jobLength) {
		this.jobLength = jobLength;
	}


	/**
	 * @return the currentJobLength
	 */
	public int getCurrentJobLength() {
		return currentJobLength;
	}


	/**
	 * @param currentJobLength the currentJobLength to set
	 */
	public void setCurrentJobLength(int currentJobLength) {
		this.currentJobLength = currentJobLength;
	}


	/**
	 * @return the jobPriority
	 */
	public int getJobPriority() {
		return jobPriority;
	}


	/**
	 * @param jobPriority the jobPriority to set
	 */
	public void setJobPriority(int jobPriority) {
		this.jobPriority = jobPriority;
	}


	/**
	 * @return the finalPriority
	 */
	public int getFinalPriority() {
		return finalPriority;
	}


	/**
	 * @param finalPriority the finalPriority to set
	 */
	public void setFinalPriority(int finalPriority) {
		this.finalPriority = finalPriority;
	}


	/**
	 * @return the entryTime
	 */
	public long getEntryTime() {
		return entryTime;
	}


	/**
	 * @param entryTime the entryTime to set
	 */
	public void setEntryTime(long entryTime) {
		this.entryTime = entryTime;
	}


	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}


	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}


	/**
	 * @return the waitTime
	 */
	public long getWaitTime() {
	//	long waitTime=getEndTime()-getEntryTime()-getJobLength();
		return waitTime;
	}


	/**
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}


	@Override
	public String toString() {
		return "Now executing " + jobName + ". Job length: " + jobLength + " cycles. Current remaining length: " 
	            + currentJobLength + " cycles. Initial Priority: " + jobPriority + ". Current Priority: " + finalPriority;
	}


	
	
	

}
