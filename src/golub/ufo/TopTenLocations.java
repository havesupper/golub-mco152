package golub.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.Gson;

public class TopTenLocations {

	public static void main(String[] vargs) throws IOException {
		// what are the top 10 UFO Sighting Locations in order and
		// the number of UFO sightings they have
		BufferedReader in = new BufferedReader(new FileReader(
				"./ufo_awesome.json"));

		Gson gson = new Gson();

		UFOSightingList list = gson.fromJson(in, UFOSightingList.class);
		HashMap<String, Integer> sightings = new HashMap<String, Integer>();

		for (UFOSighting sightedAt : list) {
			String location = sightedAt.getLocation();
			if (sightings.containsKey(location)) {
				sightings.put(location, sightings.get(location) + 1);

			} else {
				sightings.put(location, 1);
			}
		}

		List<Integer> orderedSightings = new ArrayList<Integer>(
				sightings.values());

		Collections.sort(orderedSightings);
		Collections.reverse(orderedSightings);

		for (int i = 0; i < 10; i++) {
			for (Entry<String, Integer> entry : sightings.entrySet()) {
				if (orderedSightings.get(i) == entry.getValue()) {
					System.out.println(entry.getKey() + " - "
							+ entry.getValue() + " sightings.");
				}
			}
		}
		in.close();
	}
}
