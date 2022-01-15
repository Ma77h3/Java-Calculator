import java.util.StringTokenizer;

public class postFix {

	// first method, converting a string to a queue from the tokens
	public Queue parse(String arg) {
		// initialize a string tokenizer
		StringTokenizer st = new StringTokenizer(arg,"+-*/()^",true);
		// create a queue object to store the information
		Queue queue = new Queue();
		// add all the token to the queue using the enqueue method
		while (st.hasMoreTokens()) {
			queue.enqueue(st.nextToken());
		}
		return queue;
	
	}
	
	// second method, switch from the the infix to postfix queue
	public Queue In2Post (Queue Qin) {
		// create a new queue and stack object
		Queue postfix_q = new Queue();
		Stack postfix_s = new Stack();
		
		// while the input queue still has nodes...
		while (Qin.Front != null) {
			
			// check if the node is an operator, i.e it has a precedence
			if (Qin.Front.precedence != 0) {
				
				// check if there is nothing in the stack
				// if so start the stack with that variable using the push method
				if (postfix_s.top == null) {
					postfix_s.push(Qin.Front.instance);
					// move on to the next node in the queue
					Qin.Front = Qin.Front.next;
					}
				
				// if the precedence is higher in the stack then the next input
				// empty that operator to the new queue
				else if (Qin.Front.precedence <= postfix_s.top.precedence) {
						postfix_q.enqueue(postfix_s.pop());
				}
				// if new input has higher precedence over the top one in the stack
				// push the new input into the stack
				else {
					postfix_s.push(Qin.Front.instance);
					// move on to the next operator
					Qin.Front = Qin.Front.next;
				}
			}
			// if the instance length is 1, then it could be a parenthesis
			// check if it is a parenthesis by using ASCII code and intializing an integer
			// and check if the codes match
			
			else if(Qin.Front.instance.length() == 1) {
				int j = Qin.Front.instance.charAt(0);
				
				// if the object is a left parenthesis, add it to the stack
				if (j == 40) {
					postfix_s.push(Qin.Front.instance);
					Qin.Front = Qin.Front.next;
				}
				// if is a right parenthesis, pop all operators until the left parenthesis is reached
				// then stop and pop the left parenthesis additionally as well
				else if(j == 41) {
					int k = Qin.Front.instance.charAt(0);
					while (k != 40) {
						if (postfix_s.top==null) {
							break;
						}
						
						k = postfix_s.top.instance.charAt(0);
						if (k == 40) {
							postfix_s.pop();
							break;
						}
						else {
							postfix_q.enqueue(postfix_s.top.instance);
							postfix_s.pop();
						}
					}
					Qin.Front = Qin.Front.next;
				}
				// if it is not a parenthesis, then it is a single-digit number so add it to the queue
				else {
					postfix_q.enqueue(Qin.Front.instance);
					Qin.Front = Qin.Front.next;
				}
			
			}	
			
			// if the function reaches here then it means that it is a number with more than one digit
			// similar to the one digit number, add it to the queue
			else {
				postfix_q.enqueue(Qin.Front.instance);
				Qin.Front = Qin.Front.next;
				}
		
			}
		// check if there are any operators still in the stack when all the input queue's nodes have been 
		// sorted, if so add them to the stack
		while(postfix_s.top != null) {
			postfix_q.enqueue(postfix_s.pop());
		}
		// return the new queue
		return postfix_q;
		}
	
	public double PostEval (Queue PostFix) {
		// create a double variable
		double result = 0;
		// create a stack object to keep track of numbers
		Stack operand = new Stack();
		// while the input queue is not empty
		while (PostFix.Front!=null) {
			// check if instance is a operator (it has a precedence)
			if (PostFix.Front.precedence != 0) {
				// set the result to zero
				result = 0;
				// dequeue the operator
				String token = PostFix.dequeue();
				
				// initalize two string objects
				String OP_A;
				String OP_B;
				
				// check if it is a unary operator, meaning only one object in the stack
				if (operand.top.next == null) {
					// set the first string to the top of the stack
					OP_A = operand.pop();
					// set the second string to 0
					OP_B = "0";
				}
				else {
					// set the string to the top and the second top of the stack
					OP_A = operand.pop();
					OP_B = operand.pop();
				}
				// turn the strings to the doubles
				Double A = Double.parseDouble(OP_A);
				Double B = Double.parseDouble(OP_B);
				
				
				switch (token) {
				// if token is an addition sign add the doubles
				case "+":
					result = B+A;
					break;
					// if token is an subtraction sign subtract the doubles
				case "-":
					result = B-A;
					break;
					// if the sign is a multiplication sign, multiply the doubles
				case "/":
					result = B/A;
					break;
					// if the sign is a division sign, divide the doubles
				case "*":
					result = B*A;
					break;
					// if the sign is an exponential, take the exponent of the doubles
				case "^":
					result = Math.pow(B, A);
					break;
				}
				// push the new result into the stack
				operand.push(Double.toString(result));
			}
			// if the front of the queue is a number, put it in the stack
			else {
				operand.push(PostFix.Front.instance);
				PostFix.Front = PostFix.Front.next;
			}
		}
		// return the result, (i.e, latest calculation with the numbers)
		return result;
	}
	}



