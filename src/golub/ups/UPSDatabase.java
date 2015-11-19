package golub.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {
	
	private HashMap<Package, Location> map;
	private HashMap<Location, HashSet<Package>> mapLP;
	
	public UPSDatabase(){
		map = new HashMap<Package, Location>();
		mapLP = new HashMap<Location, HashSet<Package>>();
	}

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation( Location location, Package pkg ) {
		map.put(pkg, location);
		if (mapLP.containsKey(location)){
			HashSet<Package> p = mapLP.get(location);
			p.add(pkg);
			mapLP.put(location, p);
		}
		else{
			HashSet<Package> p = new HashSet<Package>();
			p.add(pkg);
			mapLP.put(location, p);
		}
	}
	
	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation( Package pkg, Location location ) {
		Location l = getLocation(pkg);
		HashSet<Package> p = mapLP.get(l);
		p.remove(pkg);
		mapLP.put(l, p);
		
		addPackageToLocation(location, pkg);
		map.put(pkg, location);
		
	}
	
	/**
	 * @return a Set of Packages at the specified Location or an empty Set if 
	 * the Location doesn't exist or there are no Packages at that Location.
	 */
	public Set<Package> getPackages( Location location ) {
		if (mapLP.get(location) == null) {
			return new HashSet<Package>();
		}
		return mapLP.get(location);
	}
	
	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		return map.get(pkg);
	}
	
	
}
