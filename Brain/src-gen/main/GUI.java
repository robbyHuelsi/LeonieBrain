package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class GUI extends JFrame{
	private JFrame total;
	JTable tableStateInfo;
	
	public GUI(Start start){
		super("LeonieBrain");
		
		total = new JFrame ("Leonie Brain");
		total.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		BorderLayout bl = new BorderLayout();		
		total.setLayout(bl);
		
		JComboBox comboStatemachines = new JComboBox(start.getStatemachineNames());
		JButton buttonStart = new JButton("Start");
		buttonStart.setForeground(new Color(0, 255, 0));
		
		JPanel panelStateChoose = new JPanel();
		panelStateChoose.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelStateChoose.add(comboStatemachines);
		panelStateChoose.add(buttonStart); 
		total.add(panelStateChoose,BorderLayout.NORTH);
		
		
		
		JTabbedPane tabPane = new JTabbedPane();
		JPanel panelModules = new JPanel();
		JPanel panelPersons = new JPanel();
		JPanel panelLog = new JPanel();
		
		// Build computers table
		class tableStateInfoModel extends AbstractTableModel {
			private static final long serialVersionUID = 1L;
			String[] columnNames = { "A", "B"};

			public int getColumnCount() {
				return columnNames.length;
			}

			public int getRowCount() {
				if (start.getStatemachine() == null) {
					return 0;
				}else{
					return 3;
				}
			}

			public String getColumnName(int col) {
				return columnNames[col];
			}
			
			public Object getValueAt(int row, int col) {
				if (row == 0){
					if (col == 0) {
						return "Name";
					}else{
						return start.getStatemachine().getName();
					}
				}else if (row == 1)
					if (col == 0) {
						return "Duration";
					}else{
						return start.getStatemachine().getDurationString();
					}
				else
					if (col == 0) {
						return "Current State";
					}else{
						return start.getStatemachine().getCurrState();
					}
			}
		}
		
		tableStateInfo = new JTable(new tableStateInfoModel()){
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		        return component;
	        }
		};

		tableStateInfo.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		JTable tableModules = new JTable(2,2);
		panelModules.add(tableModules);
		
		JTable tablePersons = new JTable(2,2);
		panelPersons.add(tablePersons);
		
		JTextArea textAreaLog = new JTextArea();
		panelLog.add(textAreaLog);
		
		tabPane.add("Statemachine", tableStateInfo);
		tabPane.add("Modules", panelModules);
		tabPane.add("Persons", panelPersons);
		tabPane.add("Log", panelLog);
		
		total.add(tabPane, BorderLayout.CENTER);
		
		total.setSize(500,200);
		total.setVisible(true);
		
		
		
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (start.getStatemachine() == null) {
					start.setStatemachine(comboStatemachines.getSelectedItem().toString(), start);
					start.getStatemachine().setOperationCallbacks();
					
					comboStatemachines.setEnabled(false);
					//buttonStart.setEnabled(false);
					buttonStart.setText("Stop");
					buttonStart.setForeground(new Color(255, 0, 0));
					//buttonStart.updateUI();
					
					start.runStatemachine(start);
				}else{
					start.setStatemachine(null, start);
					
					comboStatemachines.setEnabled(true);
					//buttonStart.setEnabled(true);
					buttonStart.setText("Start");
					buttonStart.setForeground(new Color(0, 255, 0));
					//buttonStart.updateUI();
				}
				
			}
		});
	}
	
	public void updateUI(){
		tableStateInfo.updateUI();
	}

}
