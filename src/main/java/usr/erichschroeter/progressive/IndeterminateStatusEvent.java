package usr.erichschroeter.progressive;

/**
 * Fired when the status of a {@link AbstractProgressMonitor} changes. The event
 * provides the value boundaries as well as the current value, along with an
 * optional status text.
 * 
 * @author Erich Schroeter
 */
@SuppressWarnings("serial")
public class IndeterminateStatusEvent extends StatusEvent {

	boolean complete;

	/**
	 * Constructs a <code>StatusEvent</code> specifying no status text.
	 * 
	 * @param source
	 *            the object which fired the event
	 */
	public IndeterminateStatusEvent(Object source) {
		this(source, null);
	}

	/**
	 * Constructs a <code>StatusEvent</code> specifying the status text.
	 * 
	 * @param source
	 *            the object that fired the event
	 * @param text
	 *            a status message providing status information (optional)
	 */
	public IndeterminateStatusEvent(Object source, String text) {
		super(source, text);
	}

	/**
	 * Returns the value of the package protected complete variable.
	 * 
	 * @return <code>true</code> if progress is deemed completed, else
	 *         <code>false</code>
	 */
	@Override
	public boolean isCompleted() {
		return complete;
	}

}
