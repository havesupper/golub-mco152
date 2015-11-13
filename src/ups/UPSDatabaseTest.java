package ups;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase data = new UPSDatabase();
		Location location = new Location(100, 100);
		Package p = new Package("123track");
		data.addPackageToLocation(location, p);
		Assert.assertTrue(data.getPackages(location) == p);
		Assert.assertTrue(data.getLocation(p) == location);
	}
	
	@Test 
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase data = new UPSDatabase();
		Location location = new Location(100,100);
		Location location2 = new Location(150,150);
		Package pck = new Package("tracker");
		data.addPackageToLocation(location, pck);
		data.updatePackageLocation(pck, location2);
		Assert.assertTrue(data.getPackages(location2)==pck);
		Assert.assertTrue(data.getLocation(pck)==location2);
		Assert.assertFalse(data.getLocation(pck)==location);
	}
	
	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase data = new UPSDatabase();
		Location location = new Location(10,10);
		Set<Package> packages = new HashSet<Package>();
		Assert.assertEquals(packages, data.getPackages(location));
	}
	
	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase data = new UPSDatabase();
		Package pkg = new Package("lajsldk");
		Assert.assertNull(data.getLocation(pkg));
	}
	
}
