/**
 * 
 */
package net.aquarium.framework.concurrent;

import net.aquarium.framework.component.CompCore;
import net.aquarium.model.ExecutionContext;

/**
 * @author ducbq
 *
 */
public abstract class WorkerThreadCore extends CompCore implements Runnable {
	private static final long serialVersionUID = -2857158059074111900L;

	protected ExecutionContext executionContext;

	public WorkerThreadCore(ExecutionContext executionContext) {
		this.executionContext = ExecutionContext.builder().build();
		this.executionContext.putAll(executionContext);
	}

	@Override
	public void run() {
		perform();
	}

	protected abstract void perform();
}
