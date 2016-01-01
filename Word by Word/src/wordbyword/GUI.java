package wordbyword;

/*
 * This class contains all the components for the GUI.
 * This means everything that is shown on screen, including the box for the user to type in.
 */

// Imports: All GUI components
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame 
{
	private final JTextField userInput;
	private final JButton clear;
	private final JLabel lastWord;
	private final JLabel wordLength;
	
	
	// Constructor
	public GUI()
	{
		// Labels the window
		super("Word by Word Proof of Concept");
		
		// Sets the layout of the window
		setLayout(new FlowLayout());
		
		// Initializes GUI Components
		userInput = new JTextField();
		userInput.setColumns(30);
		
		SpaceDetector spaceDetector = new SpaceDetector();
		userInput.addKeyListener(spaceDetector);
		add(userInput);
		
		clear = new JButton("Clear Text");
		
		// code to clear text in the text field
		clear.addActionListener
		(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent event)
				{
					userInput.setText("");
					lastWord.setText("");
					wordLength.setText("");
				}
			}
		);
		add(clear);
		
		lastWord = new JLabel("");
		add(lastWord);
		
		wordLength = new JLabel("");
		add(wordLength);
		
		
	}
	
	
	// Event Handler for the Text field
	private class SpaceDetector implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == ' ')
			{
				String lastWordTyped = userInput.getText().substring(userInput.getText().lastIndexOf(" ")+1);
				lastWord.setText(String.format("The last word typed was '%s'.", lastWordTyped));
				wordLength.setText(String.format("Length = %d", lastWordTyped.length()));
			}			
		}
		
	}
}
