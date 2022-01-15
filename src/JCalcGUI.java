import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.gui.DoubleField;
import acm.gui.TableLayout;
import acm.program.Program;

public class JCalcGUI extends Program{
	
	public void init() {
		// set a table layout of 9 rows and 4 columns
		setLayout(new TableLayout(9,4));
		// add a input textfield that takes in text and stretch it to the whole column
		input = new JTextField("");
		// add a new doublefield for returning the result of the input and stretch it to the whole column
		output = new DoubleField(0.0);
		add(input, "gridwidth=4");
		add(output, "gridwidth=4");
		// add buttons representing numbers 1-9, operators (+-*/) and other commands (., C, Quit)
		add(new JButton("C"));    
		add(new JButton(""));
		add(new JButton(""));
		add(new JButton("/"));
		add(new JButton("7"));
		add(new JButton("8"));
		add(new JButton("9"));
		add(new JButton("*"));
		add(new JButton("4"));
		add(new JButton("5"));
		add(new JButton("6"));
		add(new JButton("-"));
		add(new JButton("1"));
		add(new JButton("2"));
		add(new JButton("3"));
		add(new JButton("+"));
		add(new JButton("0"));
		add(new JButton("."));
		add(new JButton(""));
		add(new JButton("="));
		add(new JButton("("));
		add(new JButton(")"));
		add(new JButton(""));
		add(new JButton("^"));
		add(new JButton(""));
		add(new JButton(""));
		add(new JButton("Del"));
		add(new JButton("Quit"));
		// add action listeners to listen for buttons pressed
		addActionListeners();
		
		// add key listeners to listen for the enter being pressed
		input.addKeyListener(this);
	}
	public void keyPressed(KeyEvent e) {
		// if the integer key code matches that of the enter key
		// put the input field into a queue and compute the answer by using all the methods in postfix
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			postFix calculations = new postFix();
			output.setValue(calculations.PostEval(calculations.In2Post(calculations.parse(input.getText()))));
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		// if the equals button was pressed
		// put the input field into a queue and compute the answer by using all the methods in postfix
		String cmd = e.getActionCommand();
		if (cmd.equals("=")){
			postFix calculations = new postFix();
			output.setValue(calculations.PostEval(calculations.In2Post(calculations.parse(input.getText()))));
		}
			
			
		}
		// if the C button was pressed
		// clear all the results in the input and output field
		else if (cmd.equals("C")) {
			input.setText("");
			output.setValue(0.0);
		}
		// if the Quit button was pressed
		// close the program
		else if (cmd.equals("Quit")) {
			System.exit(0);
		}
		// must mean that one of the numbers/operators was pressed, add the character into the input text
		else {
			String current_input = input.getText();
			current_input += cmd;
			input.setText(current_input);
		}
	}

	
	
	private JTextField input;
	private DoubleField output;
}
