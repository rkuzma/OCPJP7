import java.util.*;

public class Show {
	private static final Show INSTANCE // store one instance
	= new Show();
	// (this is the singleton)
	private Set<String> availableSeats;

	public static Show getInstance() { // callers can get to
		return INSTANCE;
		// the instance
	}

	private Show() {
		// callers can't create
		// directly anymore.
		// Must use getInstance()
		availableSeats = new HashSet<String>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}

	public boolean bookSeat(String seat) {
		return availableSeats.remove(seat);
	}

	public static void main(String[] args) {
		ticketAgentBooks("1A");
		ticketAgentBooks("1A");
	}

	private static void ticketAgentBooks(String seat) {
		Show show = Show.getInstance();
		System.out.println(show.bookSeat(seat));
	}
}