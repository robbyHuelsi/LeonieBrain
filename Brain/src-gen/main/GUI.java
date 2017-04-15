package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI extends JFrame{
	private JFrame total;
	
	
	public GUI(Start start){
		super("LeonieBrain");
		
		total = new JFrame ("Leonie Brain");
		total.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		BorderLayout bl = new BorderLayout();		
		total.setLayout(bl);
		
		JComboBox comboStatemachines = new JComboBox(start.getStatemachineNames());
		JButton buttonStart = new JButton("Start");
		buttonStart.setForeground(new Color(0, 255, 0));
		
		JPanel panelStatemachines = new JPanel();
		panelStatemachines.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelStatemachines.add(comboStatemachines);
		panelStatemachines.add(buttonStart); 
		
		total.add(panelStatemachines,BorderLayout.NORTH);
		
		total.setSize(500,200);
		total.setVisible(true);
		
		
		
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (start.getStatemachine() == null) {
					start.setStatemachine(comboStatemachines.getSelectedItem().toString());
					start.getStatemachine().setOperationCallbacks();
					
					comboStatemachines.setEnabled(false);
					//buttonStart.setEnabled(false);
					buttonStart.setText("Stop");
					buttonStart.setForeground(new Color(255, 0, 0));
					//buttonStart.updateUI();
					
					start.runStatemachine();
				}else{
					start.setStatemachine(null);
					
					comboStatemachines.setEnabled(true);
					//buttonStart.setEnabled(true);
					buttonStart.setText("Start");
					buttonStart.setForeground(new Color(0, 255, 0));
					//buttonStart.updateUI();
				}
				
			}
		});
	}

}
