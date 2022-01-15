
// Queue class that has two listnode pointers, front and rear
public class Queue{
	listNode Front;
	listNode Rear;
	
	// first method adding a new listnode to the rear of the queue
	public void enqueue(String arg) {
		// creates a new list node
		listNode n = new listNode();
		// initialize in the instance to the input string
		n.instance = arg;
		// check if the length of the input is 1, it could possible be an operator
		// if so initialize a int variable to represent the ASCII code of the string
		if (arg.length() == 1) {
			int j = arg.charAt(0);
			// check if the string is either a "*", "%", "/"
			// if so set the precedence to 3
			if (j == 47 || j == 42 || j == 37) {
				n.precedence = 3;
			}
			// check if the string is a "^"
			// if so set the precedence to 4
			else if (j == 94) {
				n.precedence = 4;
			}
			
			// check if the string is either a "+", "-"
			// if so set the precedence to 2
			else if(j == 43|| j == 45) {
				n.precedence = 2;
			}
			
			// it is not an operator then, so set the precedence to 0
			else {
				n.precedence = 0;
			}
		}
		// if the length is not one, then it is not an operator, set the precedence to 0
		else {
			n.precedence = 0;
		}
		
		// if the queue is empty, set this both Front and Rear to point to the new listnode
		if (Front==null) {
			Front = n;
			Rear = n;
		}
		
		// if not, connect the previous rear next to the new input and set that new input to the rear
		else {
			Rear.next = n;
			Rear = n;
		}
		
	}
	
	// second method, removing a listnode from the queue
	public String dequeue() {
		
		// have a pointer to the front listnode string
		String out = Front.instance;
		// move up one, and go to the next node
		Front = Front.next;
		// return the string
		return out;
	}
	
	
	// third method showing the string of a queue
	public String toString() {
		// initialize a empty string
		String out = "";
		// create another pointer to that mics Front
		listNode copy = Front;
		// go through every list node (from Front to Rear) and concatenate the 
		// string instance of each list node as well as a space, unless it is the last listnode
		// of the queue
		while (copy != null) {
			out += copy.instance;
			if(copy==Rear) {
				copy = copy.next;
			}
			else {
				out += " ";
				copy = copy.next;
			}
		}
		// return the new string
		return out;
	}
	
	

}
