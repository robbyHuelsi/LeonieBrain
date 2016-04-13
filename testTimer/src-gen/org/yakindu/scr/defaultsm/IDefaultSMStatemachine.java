package org.yakindu.scr.defaultsm;
import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IDefaultSMStatemachine extends ITimerCallback, IStatemachine {
	public interface SCInterface {

		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback);
	}

	public interface SCInterfaceOperationCallback {
		public void print(String msg);
	}

	public SCInterface getSCInterface();

}
