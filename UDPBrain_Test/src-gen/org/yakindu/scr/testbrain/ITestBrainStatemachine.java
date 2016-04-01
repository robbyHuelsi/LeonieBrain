package org.yakindu.scr.testbrain;
import org.yakindu.scr.IStatemachine;

public interface ITestBrainStatemachine extends IStatemachine {

	public interface SCIUdpInterface {
		public String getData();
		public void setData(String value);

		public void setSCIUdpInterfaceOperationCallback(SCIUdpInterfaceOperationCallback operationCallback);
	}

	public interface SCIUdpInterfaceOperationCallback {
		public void receive();
	}

	public SCIUdpInterface getSCIUdpInterface();

	public interface SCIPrintDataInterface {

		public void setSCIPrintDataInterfaceOperationCallback(SCIPrintDataInterfaceOperationCallback operationCallback);
	}

	public interface SCIPrintDataInterfaceOperationCallback {
		public void print();
	}

	public SCIPrintDataInterface getSCIPrintDataInterface();

}
