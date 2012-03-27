package usr.erichschroeter.progressive;

import java.util.EventObject;

/**
 * Fired when the status of a {@link AbstractProgressMonitor} changes. The event
 * provides the value boundaries as well as the current value, along with an
 * optional status text.
 * 
 * @author Erich Schroeter
 */
@SuppressWarnings("serial")
public class StatusEvent extends EventObject {

	/** The status text. */
	String text;

	/**
	 * Constructs a <code>StatusEvent</code> specifying the current status value
	 * and its boundaries.
	 * 
	 * @param source
	 *            the object which fired the event
	 */
	public StatusEvent(Object source) {
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
	public StatusEvent(Object source, String text) {
		super(source);
		this.text = text;
	}

	/**
	 * Returns the optional status text for this status event.
	 * 
	 * @return the status text, or <code>null</code> if there is none
	 */
	public String getText() {
		return text;
	}

	/**
	 * Returns whether the progress is completed.
	 * <p>
	 * This will return <code>false</code> unless overridden in a derived class.
	 * 
	 * @return <code>true</code> if the progress has completed, else
	 *         <code>false</code>
	 */
	public boolean isCompleted() {
		return false;
	}

}
