package usr.erichschroeter.progressive;

/**
 * Monitors the progress of some action. This class used in conjunction with
 * {@link ProgressDialog} can be used to notify an end user of the progress of
 * an action being performed in the background.
 * 
 * @author Erich Schroeter
 * @see ProgressDialog
 * @see ProgressUtil
 */
public class IndeterminateProgressMonitor extends AbstractProgressMonitor {

	private IndeterminateStatusEvent statusEvent;

	/**
	 * Constructs a default <code>ProgressMonitor</code> specifying 0
	 * milliseconds to wait for a dialog to display.
	 * 
	 * @see #IndeterminateProgressMonitor(int)
	 */
	public IndeterminateProgressMonitor() {
		this(0);
	}

	/**
	 * Constructs a <code>ProgressMonitor</code> specifying the milliseconds to
	 * wait before displaying a dialog.
	 * 
	 * @param milliSecondsToWait
	 *            time to wait before dialog is displayed
	 * @see AbstractProgressMonitor#AbstractProgressMonitor(int)
	 */
	public IndeterminateProgressMonitor(int milliSecondsToWait) {
		super(milliSecondsToWait);
		this.statusEvent = new IndeterminateStatusEvent(this);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The event fired is an {@link IndeterminateStatusEvent}.
	 */
	@Override
	public void start(String status) {
		fireProgressEvent(new IndeterminateStatusEvent(this, status));
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The event fired is an {@link IndeterminateStatusEvent}.
	 */
	@Override
	public void cancel(String status) {
		fireProgressCanceledEvent(new IndeterminateStatusEvent(this, status));
	}

	/**
	 * Returns the text of the status event. This is information often useful to
	 * display to the end user to notify them on what is occurring in the
	 * background.
	 * 
	 * @return the status text
	 */
	public String getStatusText() {
		return statusEvent.text;
	}

	/**
	 * Sets the status text and fires a status event. This is information often
	 * useful to display to the end user to notify them on what is occurring in
	 * the background.
	 * 
	 * @param status
	 *            the status text
	 */
	public void updateStatusText(String status) {
		statusEvent.text = status;
		fireProgressEvent(statusEvent);
	}

	/**
	 * Sets whether the progress has completed and fires a status event.
	 * <p>
	 * An indeterminate progress is considered complete when the user specifies
	 * it is complete. Thus it is left up to the developer to specify that the
	 * progress is completed, else the progress will continue on indefinitely.
	 * 
	 * @param complete
	 *            <code>true</code> if progress is completed, else
	 *            <code>false</code>
	 */
	public void setCompleted(boolean complete) {
		statusEvent.complete = complete;
		fireProgressEvent(statusEvent);
	}
}
