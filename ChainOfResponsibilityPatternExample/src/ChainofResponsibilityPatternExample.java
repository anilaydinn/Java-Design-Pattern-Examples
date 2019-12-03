
public class ChainofResponsibilityPatternExample {

	public static void main(String[] args) {
		
		System.out.println("\n ***Chain of Responsibility Pattern Demo***\n");
		
		/*
		 	Forming the chain as IssueRaiser -> FaxErrorhandler -> EmailErrorHandler
		 */
	}
}

enum MessagePriority{
	
	NORMAL,
	HIGH
}

class Message{
	
	public String text;
	public MessagePriority priority;
	
	public Message(String msg, MessagePriority p) {
		
		text = msg;
		priority = p;
	}
}

interface Receiver{
	
	boolean handleMessage(Message message);
	void nextErrorHandler(Receiver nextReceiver);
}

class IssueRaiser{
	
	public Receiver setFirstReceiver;
	
	public void setFirstErrorHandler(Receiver firstErrorHandler) {
		
		this.setFirstReceiver = firstErrorHandler;
	}
	
	public void raiseMessage(Message message) {
		
		if(setFirstReceiver != null) {
			
			setFirstReceiver.handleMessage(message);
		}
	}
}

//FaxErrorHandler class
class FaxErrorHandler implements Receiver{
	
	private Receiver nextReceiver;
	
	@Override
	public void nextErrorHandler(Receiver nextReceiver) {
		
		this.nextReceiver = nextReceiver;
	}
	
	@Override
	public boolean handleMessage(Message message) {
		
		if(message.text.contains("Fax")) {
			
			System.out.println("FaxErrorHandler processed " + message.priority + " priority issue: " + message.text);
			return true;
		}
		else {
			
			if(nextReceiver != null) {
				
				nextReceiver.handleMessage(message);
			}
		}
		return false;
	}
}

//EmailErrorHandler
class EmailErrorHandler implements Receiver{
	
	private Receiver nextReceiver;
	
	@Override 
	public void nextErrorHandler(Receiver nextReceiver) {
		
		this.nextReceiver = nextReceiver;
	}
	
	@Override
	public boolean handleMessage(Message message) {
		
		if(message.text.contains("Email")) {
			
			System.out.println("EmailErrorHandler processed " + message.priority + " priority issue: " + message.text);
			return true;
		}
		else {
			
			if(nextReceiver != null) {
				
				nextReceiver.handleMessage(message);
			}	
		}
		return false;
	}
}


