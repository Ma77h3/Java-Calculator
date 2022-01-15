
public class Stack {
	// has one pointer to a list node
	listNode top;
	
	
	// first method, adding an object to the stack
	public void push(String arg) {
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
		
		// if the stack is empty, set this new list node to the pointer top
		if (top==null) {
			top = n;
		}
		// if the stack is not empty, add it by connecting the previous top back to 
		// the new listnode and changing the listnode to top
		else {
			n.next=top;
			top = n;
		}
	}
	 // second method, removing a listnode from the stack
	public String pop() {
		// set a pointer to the string of the listnode instance
		String out = top.instance;
		
		// go back one step to the previous node on the top
		top = top.next;
		
		// return the string
		return out;
	}
	
	public String toString() {
		String out = "";
		// create another pointer to that mics Front
		listNode copy = top;
		// go through every list node (from Front to Rear) and concatenate the 
		// string instance of each list node as well as a space, unless it is the last listnode
		// of the queue
		while (copy != null) {
			out += copy.instance;
			if(copy !=null) {
				copy = copy.next;
				out += " ";
			}
		}
		// return the new string
		return out;
	}

}
