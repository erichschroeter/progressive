package usr.erichschroeter.progressive;

import javax.swing.event.EventListenerList;

/**
 * Monitors the progress of some action. This class used in conjunction with
 * {@link ProgressDialog} can be used to notify an end user of the progress of
 * an action being performed in the background.
 * 
 * @author Erich Schroeter
 * @see ProgressDialog
 * @see ProgressUtil
 */
public abstract class AbstractProgressMonitor implements ProgressMonitor {

	private EventListenerList listeners;
	/** Number of milliseconds to wait before a dialog displays. */
	private int milliSecondsToWait;

	/**
	 * Constructs a default <code>ProgressMonitor</code> specifying negative
	 * values for the progress, which means this monitor is indeterminate.
	 * 
	 * @param milliSecondsToWait
	 *            time to wait before dialog is displayed
	 */
	public AbstractProgressMonitor(int milliSecondsToWait) {
		this.milliSecondsToWait = milliSecondsToWait;
	}

	/**
	 * Returns the number of milliseconds to wait before displaying a progress
	 * dialog.
	 * 
	 * @return number of milliseconds to wait before displaying dialog
	 */
	public int getMilliSecondsToWait() {
		return milliSecondsToWait;
	}

	/**
	 * Adds the progress listener to receive status events on the progress.
	 * 
	 * @param listener
	 *            the progress listener to add
	 */
	public void addProgressListener(ProgressListener listener) {
		if (listeners == null) {
			listeners = new EventListenerList();
		}
		if (listener == null) {
			return;
		}
		listeners.add(ProgressListener.class, listener);
	}

	/**
	 * Removes the progress listener from the list to receive status events on
	 * the progress.
	 * 
	 * @param listener
	 *            the progress listener to remove
	 */
	public void removeProgressListener(ProgressListener listener) {
		if (listeners == null || listener == null) {
			return;
		}
		listeners.remove(ProgressListener.class, listener);
	}

	/**
	 * Starts the progress monitor.
	 * <p>
	 * This is equivalent to <code>start(null)</code>.
	 * 
	 * @see #start(String)
	 */
	@Override
	public void start() {
		start(null);
	}

	/**
	 * Starts the progress monitor also specifying a status message and then
	 * fires a status event.
	 * 
	 * @param status
	 *            the message to display to the user
	 */
	public void start(String status) {
		fireProgressEvent(new StatusEvent(this, status));
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This is equivalent to <code>cancel(null)</code>.
	 * 
	 * @see #cancel(String)
	 */
	@Override
	public void cancel() {
		cancel(null);
	}

	/**
	 * Cancels monitoring the progress by firing a progress canceled event and
	 * specifies a status message.
	 * 
	 * @param status
	 *            the status message for canceling
	 */
	public void cancel(String status) {
		fireProgressCanceledEvent(new StatusEvent(this, status));
	}

	/** Fires a status changed event. */
	protected void fireProgressEvent(StatusEvent e) {
		if (listeners == null || e == null) {
			return;
		}
		ProgressListener[] listeners = this.listeners
				.getListeners(ProgressListener.class);
		for (ProgressListener l : listeners) {
			l.statusChanged(e);
		}
	}

	/** Fires a progress canceled status event. */
	protected void fireProgressCanceledEvent(StatusEvent e) {
		if (listeners == null || e == null) {
			return;
		}
		ProgressListener[] listeners = this.listeners
				.getListeners(ProgressListener.class);
		for (ProgressListener l : listeners) {
			l.canceled(e);
		}
	}
}
