package secondcalc;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

 public class main extends JFrame implements Actionistener{
	
	static JFrame frame;
	
	static JTextField result;

	public static void main(String[]args) { 
		main listen = new main();
		frame = new JFrame("Калькулятор");
		result = new JTextField(16);
		result.setEditable(false);
		
		
		
		ArrayList<JButton> btns = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			 JButton jTmpButton = new JButton(Integer.toString(i));
			 jTmpButton.addActionListener(listen);
			 btns.add(jTmpButton);  
		}
		
			List<String> operations = Arrays .asList("+","-","*","/",".","c");
	
	JPanel buttons = new JPanel();
	btns.forEach(buttons::add);
	operations.forEach(it ->{
	JButton JTmpButton = new JButton(it);
	buttons.add(JTmpButton);
	
	});
	
	GridLayout numsAndOpsLayout = new GridLayout(4,4);
	buttons.setLayout(numsAndOpsLayout);
	
	JPanel mainPanel = new JPanel();
	mainPanel.add(result);
	mainPanel.add(buttons);
		
		frame.add(buttons);
		frame.add(result);
		frame.setSize(360,150);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		String s  = e.getActionCommand();
		if (s.charAt(0) >= '0'&& s.charAt(0) <= '9') {
			if (operation("")) 
				a = a + s;
			else
				b = b + s;
			result.setText(a + operation + b);
		} else if (s.charAt(0) == 'c') {
			a = operation = b = "";
			result.setText(a + operation + b);
		} else if (s.charAt(0) == '=') {
			int rslt = switch (operation) {
			case "+" -> Integer.parseInt(a) + Integer.parseInt(b);
			case "-" -> Integer.parseInt(a) - Integer.parseInt(b);
			case "/" -> Integer.parseInt(a) / Integer.parseInt(b);
			default -> Integer.parseInt(a) * Integer.parseInt(b);
			};
			a = String.valueOf(rslt);
			result.setText(a);
			operation = b = "";
		} else {
			if(operation.equals(""))
				operation = s;
			result.setText(a + operation + b);
		}
	}
}
 


