package usr.erichschroeter.progressive;

import java.util.EventListener;

/**
 * Receives progress events when the progress of a {@link AbstractProgressMonitor}
 * changes.
 * 
 * @author Erich Schroeter
 */
public interface ProgressListener extends EventListener {

	public void statusChanged(StatusEvent e);
	
	public void canceled(StatusEvent e);

}
