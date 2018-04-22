package zty.javaweb.springboot.entity;

import java.io.Serializable;

public class JsonResult implements Serializable{

	private static final long serialVersionUID = 3387825312162118186L;
	private final static int ERROR=1;
	private final static int SUCCESS=0;
	private Object data;
	private String Message;
	private int state;
	
	public JsonResult() {
	}
	
	public JsonResult(Throwable e){
		this.state=ERROR;
		this.Message=e.getMessage();
	}
	
	public JsonResult(int state,Throwable e){
		this.state=state;
		this.Message=e.getMessage();
	}

	public JsonResult(Object data){
		this.data=data;
		this.state=SUCCESS;		
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "JsonResult [data=" + data + ", Message=" + Message + ", state=" + state + "]";
	}
	
	
}
