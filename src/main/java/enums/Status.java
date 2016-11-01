package enums;

public enum Status {
	
	isDamaged,
	isRetruned,
	isDispatched,
	isReserved,
	isDiscontinued,
	isAvailable;

	protected Status status; 
	
	public Status getStatus(){
		return status; 
	}
	
	public void setStatus(Status status){
		this.status = status;
	}


}
