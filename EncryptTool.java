import acm.program.*;
import acm.graphics.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class EncryptTool extends Program{
	private JLabel programTitle;
	
	private JLabel inputLabel;
	private JLabel keyLabel;
	private JTextField inputField;
	private JTextField keyField;
	
	private JLabel result;
	
	public void init(){
		//Set the title of the entire program
		programTitle = new JLabel("The ENIGMA");
		programTitle.setFont(TITLE_FONT);
		add(programTitle, NORTH);
		
		//set the labels and text fields for the input message and the key
		inputLabel = new JLabel("Input: ");
		inputLabel.setFont(PROGRAM_FONT);
		add(inputLabel, WEST);
		inputField = new JTextField(INPUT_FIELD_SIZE);
		add(inputField, WEST);
		
		keyLabel = new JLabel("Key: ");
		keyLabel.setFont(PROGRAM_FONT);
		add(keyLabel, WEST);
		keyField = new JTextField(KEY_FIELD_SIZE);
		add(keyField, WEST);
		
		//add the button that activates the encryption process
		setButton("Encode with Caesar Cipher");
		setButton("Encode with Vigenere Cipher");
		
		result = new JLabel("");
		add(result, CENTER);
		
		addActionListeners();
	}
	
	private void setButton(String str){
		JButton bt = new JButton(str);
		bt.setFont(PROGRAM_FONT);
		add(bt, EAST);
	}
	
	public void actionPerformed(ActionEvent e) {
		String input = inputField.getText();
		String key = keyField.getText();
		if(!input.isEmpty()){

			if(e.getActionCommand().equals("Encode with Caesar Cipher")){
				int numKey = Integer.parseInt(key);
				String encrypted = caesarAlgorithm(input, numKey);
				result.setText(encrypted);
			}
			
			//Run vigenere algorithm when the button for it is pressed
			if(e.getActionCommand().equals("Encode with Vigenere Cipher")){
				String encrypted = viginereAlgorithm(input, key);
				result.setText(encrypted);
			}
		}
	}
	
	//Algorithm to encrypt a message using Caesar cipher.
	private String caesarAlgorithm(String str, int key){
		str = str.toUpperCase();
		String result = "";
		for(int i = 0; i < str.length(); i++){
			int n = str.charAt(i);
			if(n > 64 && n < 91){ //check if n is a letter
				n += key;
				//deal with cases when n + key is out of the range of letters in ascii
				if(n < 65){
					n += 26;
				}else if(n > 90){
					n -= 26;
				}
			}
			result += (char)n;
		}
		return result;
	}
	
	private String viginereAlgorithm (String str, String key){
		return "";
	}
	
	private static final Font TITLE_FONT = new Font ("Dialog", 12, 40);
	private static final Font PROGRAM_FONT = new Font ("Dialog", 9, 14);
	private static final int INPUT_FIELD_SIZE = 20;
	private static final int KEY_FIELD_SIZE = 10;
}
