package golub.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	private HashMap<String, Boolean> plane;
	//I realize that I should have done a seat row and column separately (which I did
	//Originally and then I switched it) because reserve group is very difficult to keep
	//separating the seats and putting them together.....

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {

		this.plane = new HashMap<String, Boolean>();
		StringBuilder builder = new StringBuilder();
		String seat;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				builder.append((char) ((char) 'A' + j));
				builder.append(i + 1);
				seat = builder.toString();
				plane.put(seat, false);
			}
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException, SeatOutOfBoundsException {

		boolean reserved = isReserved(seatName);

		if (reserved == true) {
			if (plane.containsKey(seatName) == false) {
				throw new SeatOutOfBoundsException();
			} else {
				throw new AlreadyReservedException();
			}
		}
		plane.put(seatName, true);

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {

		if (plane.containsKey(seatName)) {
			if (plane.get(seatName) == true) {
				return true;
			}
		}

		return false;

	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames) throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD\n 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append(" ");
		// Inefficient way go back and fix if have time
		for (final Entry<String, Boolean> map : plane.entrySet()) {
			String seat = map.getKey();
			char letter = seat.charAt(0);
			ArrayList<Character> letters = new ArrayList<Character>();
			if (!letters.contains(letter)) {
				letters.add(letter);
				builder.append(letter);
			}
		}
		builder.append("\n");
		for (final Entry<String, Boolean> map : plane.entrySet()) {
			String seat = map.getKey();
			int number = Integer.parseInt(seat.substring(1));
			builder.append(number + " ");

			for (final Entry<String, Boolean> maps : plane.entrySet()) {
				String seatNum = maps.getKey();
				int num = Integer.parseInt(seatNum.substring(1));
				if (num == number) {
					if (maps.getValue() == true) {
						builder.append("#");
					} else {
						builder.append("o");
					}
				}
			}
			builder.append("\n");

		}

		return builder.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether) throws NotEnoughSeatsException {
		ArrayList<String> seats = new ArrayList<String>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (final Entry<String, Boolean> map : plane.entrySet()) {
			if (map.getValue() == false) {
				String seat = map.getKey();
				int number = Integer.parseInt(seat.substring(1));
				if (row.contains(number) || row.isEmpty()){
					row.add(number);
					if (row.size() == numberOfSeatsTogether){
						for (Entry<String, Boolean>maps: plane.entrySet()){
						seats.add(map.getKey());
						
						break;
						}
					}
				}
				else{
					row.clear();
					row.add(number);
				}
			}
		}
		String seat = seats.get(0);
		char letters = seat.charAt(0);
		
		return seats;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		return (!plane.containsValue(false));
	}
}
