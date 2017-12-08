package archetype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static net.mindview.util.SwingConsole.*;

public class HtmlButton extends JFrame{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton jb = new JButton(
		        "<html><b><font size=+2>" + 
		        "<center>Hello!<br><i>Press me now"    
		        
		    );
	 
	 public HtmlButton() {
		 jb.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                add(new JLabel(
	                        "<html><i><font size=+2>kapow!"
	                ));
	                validate();
	            }
	        });
		 setLayout(new FlowLayout());
         add(jb);
	}
	 
//	 public static void main(String[] args){
//	        run(new HtmlButton(),200,500);
//	    }
}
