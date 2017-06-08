package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import callbacks.OpCallbacksInUse;

public class GUI extends JFrame{
	private JFrame total;
	private JTable tableStateInfo;
	private JTable tableModules;
	private JTable tablePersons;
	private JTextArea textAreaLog;
	private JPopupMenu tableModulesPopup;
	
	public GUI(Start start){
		super("LeonieBrain");
		
		total = new JFrame ("Leonie Brain");
		total.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		BorderLayout bl = new BorderLayout();		
		total.setLayout(bl);
		
		JComboBox comboStatemachines = new JComboBox(start.getStatemachineNames());
		comboStatemachines.setSelectedIndex(-1);
		comboStatemachines.setMaximumRowCount(50);
		
		JButton buttonStart = new JButton("Start");
		buttonStart.setForeground(new Color(0, 255, 0));
		buttonStart.setEnabled(false);
		
		JCheckBox checkBoxSendInitAll = new JCheckBox("Send Init To All Modules", true);
		checkBoxSendInitAll.setEnabled(false);
		
		JPanel panelStateChoose = new JPanel();
		panelStateChoose.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelStateChoose.add(comboStatemachines);
		panelStateChoose.add(checkBoxSendInitAll);
		panelStateChoose.add(buttonStart);
		total.add(panelStateChoose,BorderLayout.NORTH);
		
		
		
		JTabbedPane tabPane = new JTabbedPane();
		JPanel panelPersons = new JPanel();
		JPanel panelLog = new JPanel();
		
		// Build StateInfo table
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
						//return "";
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

		
		// Build Modules table
		class tableModulesModel extends AbstractTableModel {
			private static final long serialVersionUID = 1L;
			String[] columnNames = { "Name", "IP", "Port", "OP Callback", "Pong"};

			public int getColumnCount() {
				return columnNames.length;
			}

			public int getRowCount() {
				if (start.getModules() == null) {
					return 0;
				}else{
					return start.getModules().size() + 1; //Header
				}
			}

			public String getColumnName(int col) {
				return columnNames[col];
			}
			
			public Object getValueAt(int row, int col) {
				if (row == 0) {
					return columnNames[col];
				}else{
					if (col == 0) {
						return start.getModules().get(row-1).getName();
					}else if (col == 1) {
						return start.getModules().get(row-1).getIp();
					}else if (col == 2) {
						return start.getModules().get(row-1).getPort();
					}else if (col == 3) {
						//Nur weiter, wenn Sm vorhanden
						if (start.getStatemachine() == null){return "No SM";}
						
						int id = start.getModules().get(row-1).getOpCallbackId();
						
						//Nur weiter, wenn OpCallbackId nicht Null ist
						if (id == 0) {return "";}
						
						OpCallbacksInUse op = start.getStatemachine().getOpCallbackInUseById(id);
						
						//Nur weiter, wenn OpCallback gefunden wurde
						if (op == null){return "OP not found";}
						
						//Wenn keine Exeption, dann gut
						if (op.getException() == null) {
							return "yes";
						}else{ //Ansonsten ausgeben
							return op.getException().getLocalizedMessage();
						}
					}else if (col == 4) {
						long pongTime = start.getModules().get(row-1).getPongTime();
						if (pongTime == -1) {
							return "";
						}else{
							return pongTime + " ms";
						}
						
						
					}else{
						return "";
					}
				}
			}
		}
		
		tableModules = new JTable(new tableModulesModel()){
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		        return component;
	        }
		};

		tableModules.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		tableModules.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
		    public void mouseReleased(MouseEvent e) {tableModulesMousePressedReleased(e);}
			public void mousePressed(MouseEvent e) {tableModulesMousePressedReleased(e);}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});

				
		tablePersons = new JTable(2,2);
		panelPersons.add(tablePersons);
		
		textAreaLog = new JTextArea();
		panelLog.add(textAreaLog);
		
		tabPane.add("Statemachine", tableStateInfo);
		tabPane.add("Modules", tableModules);
		tabPane.add("Persons", panelPersons);
		tabPane.add("Log", panelLog);
		
		total.add(tabPane, BorderLayout.CENTER);
		
		total.setSize(600,400);
		total.setVisible(true);
		
		
		comboStatemachines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start.setStatemachine(comboStatemachines.getSelectedItem().toString(), start);
				if (start.getStatemachine().setOperationCallbacks()){
					// setOperationCallbacks() hat funktioniert
					start.getStatemachine().sendPingToAllModules();
					buttonStart.setEnabled(true);
					checkBoxSendInitAll.setEnabled(true);
				}else{
					// setOperationCallbacks() hat nicht funktioniert
					buttonStart.setEnabled(false);
					checkBoxSendInitAll.setEnabled(false);
				}
			}
		});
		
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(start.getStatemachine() != null && start.getStatemachine().isRunning()){
					//Stoppen
					start.setStatemachine(null, start);
					
					comboStatemachines.setEnabled(true);
					checkBoxSendInitAll.setEnabled(true);
					buttonStart.setText("Start");
					buttonStart.setForeground(new Color(0, 255, 0));
					comboStatemachines.updateUI();
					checkBoxSendInitAll.updateUI();
					buttonStart.updateUI();
					
				}else if (start.getStatemachine() != null && !start.getStatemachine().isRunning()) {
					//Starten
					comboStatemachines.setEnabled(false);
					checkBoxSendInitAll.setEnabled(false);
					buttonStart.setText("Stop");
					buttonStart.setForeground(new Color(255, 0, 0));
					comboStatemachines.updateUI();
					checkBoxSendInitAll.updateUI();
					buttonStart.updateUI();
					
					start.getStatemachine().sendInitToAllModules(checkBoxSendInitAll.isSelected());
					start.runStatemachine(start);
				}else{
					// Keine Statemashine ausgewählt
					if (((String)comboStatemachines.getSelectedItem()).isEmpty()) {
						System.err.println("statemashine is null");
						//Ausgangszustand
						comboStatemachines.setEnabled(true);
						checkBoxSendInitAll.setEnabled(false);
						buttonStart.setEnabled(false);
						buttonStart.setText("Start");
						buttonStart.setForeground(new Color(0, 255, 0));
						comboStatemachines.updateUI();
						checkBoxSendInitAll.updateUI();
						buttonStart.updateUI();
						
					}else{
						//Ausgewählte SM setzen und danach starten
						start.setStatemachine(comboStatemachines.getSelectedItem().toString(), start);
						if (start.getStatemachine().setOperationCallbacks()){
							//Starten
							comboStatemachines.setEnabled(false);
							checkBoxSendInitAll.setEnabled(false);
							buttonStart.setEnabled(true);
							buttonStart.setText("Stop");
							buttonStart.setForeground(new Color(255, 0, 0));
							comboStatemachines.updateUI();
							checkBoxSendInitAll.updateUI();
							buttonStart.updateUI();
							start.getStatemachine().sendInitToAllModules(checkBoxSendInitAll.isSelected());
							start.runStatemachine(start);
						}
					}
				}
				
			}
		});
		
		tableModulesPopup = new JPopupMenu("Edit Module");
//		JMenuItem cut = new JMenuItem("Cut");  
//		JMenuItem copy = new JMenuItem("Copy");  
//		JMenuItem paste = new JMenuItem("Paste");  
//		tableModulesPopup.add(cut); tableModulesPopup.add(copy); tableModulesPopup.add(paste);
	}
	
	public void updateTableStateInfoUI(){
		tableStateInfo.updateUI();
	}
	
	public void updateTableModulesUI(){
		tableModules.updateUI();
	}
	
	private void tableModulesMousePressedReleased(MouseEvent e){
		int r = tableModules.rowAtPoint(e.getPoint());
        if (r >= 1 && r < tableModules.getRowCount()) {
        	tableModules.setRowSelectionInterval(r, r);
        } else {
        	tableModules.clearSelection();
        }

        int rowindex = tableModules.getSelectedRow();
        if (rowindex < 1){
        	return;
        }
        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
        	tableModulesPopup.show(e.getComponent(), e.getX(), e.getY());
        }
	}

}
