package kodlamaio.hmrs.core.utilities.results;

import java.util.List;

import kodlamaio.hmrs.entities.concretes.Language;

public class DataResult<T> extends Result{

	private T data;
	
	public DataResult(T data,boolean success, String message) {
		super(success, message);
		this.data=data;
		
	}
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data=data;
	}
	

	public T getData() {
		return this.data;
	}

}
