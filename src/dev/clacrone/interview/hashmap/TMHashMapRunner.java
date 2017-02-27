package dev.clacrone.interview.hashmap;

public class TMHashMapRunner {
	public static void runTMHashMap() {
		TMHashMap tmhm = new TMHashMap();

		System.out.println("============== Adding Element ===================");
		Employee e1 = new Employee(100, "Niranjan");
		tmhm.put(e1, "dept1");

		// duplicate
		System.out
				.println("============== Adding Duplicate ===================");
		Employee e1_dup = new Employee(100, "Niranjan");
		tmhm.put(e1_dup, "dept12");
		// the above value "dept12" should replace the old value "dept1"
		Entry e = tmhm.get(e1_dup);
		System.out.println("GET element - " + e.getKey() + "::" + e.getValue());

		System.out
				.println("============== Adding Elements ===================");
		Employee e2 = new Employee(102, "Sravan");
		tmhm.put(e2, "dept3");

		Employee e3 = new Employee(104, "Ananth");
		tmhm.put(e3, "dept2");

		Employee e4 = new Employee(106, "Rakesh");
		tmhm.put(e4, "dept5");

		Employee e5 = new Employee(108, "Shashi");
		tmhm.put(e5, "dept2");

		// collision with e2
		System.out
				.println("============== Adding Collisions ===================");
		Employee e2_collision = new Employee(112, "Chandu");
		tmhm.put(e2_collision, "dept16");
		e = tmhm.get(e2_collision);
		System.out.println("GET element - " + e.getKey() + "::" + e.getValue());

		// collision with e3
		Employee e3_collision = new Employee(114, "Santhosh");
		tmhm.put(e3_collision, "dept9");
		e = tmhm.get(e3_collision);
		System.out.println("GET element - " + e.getKey() + "::" + e.getValue());

		System.out
				.println("============== Adding Duplicate in Collision ===================");
		Employee e3_collision_dupe = new Employee(124, "Santhosh");
		tmhm.put(e3_collision_dupe, "dept91");
		e = tmhm.get(e3_collision_dupe);
		System.out.println("GET element - " + e.getKey() + "::" + e.getValue());
	}
}
