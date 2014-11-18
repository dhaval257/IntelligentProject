import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.NeighborIndex;
import org.jgrapht.graph.SimpleGraph;

////////////////////////TODO/////////////////////////////////
/*
 * - When initializing graph with random values, the generated graph only is the solution, then throws error
 */

public class TryingGraphT {

	private static final int MAX_STEPS = 1000;
	private static final int TOTAL_AVAILABLE_COLORS = 5;
	private static List<CustomClass> conflictedStates;
	private static CustomClass tempConflictedObj;
	private static SimpleGraph<CustomClass, DefaultEdge> g;
	private static CustomClass tempFCMRVObj;

	public static void main(String args[]) {
		System.out.println("Hello");

		/*
		 * Set<DefaultEdge> set = new HashSet<DefaultEdge>(); set =
		 * g.edgesOf("v2"); System.out.println(set.toString());
		 */
		g = new SimpleGraph<CustomClass, DefaultEdge>(DefaultEdge.class);

		// add the vertices
		// My own

		CustomClass tempCClass1 = new CustomClass("Apple", 2);
		g.addVertex(tempCClass1);

		CustomClass tempCClass2 = new CustomClass("Orange", 4);
		g.addVertex(tempCClass2);

		CustomClass tempCClass3 = new CustomClass("Mango", 6);
		g.addVertex(tempCClass3);

		CustomClass tempCClass4 = new CustomClass("Kiwi", 9);
		g.addVertex(tempCClass4);

		CustomClass tempCClass5 = new CustomClass("Watermelon", 10);
		g.addVertex(tempCClass5);

		CustomClass tempCClass6 = new CustomClass("Pineapple", 7);
		g.addVertex(tempCClass6);

		// add edges g.addEdge(tempCClass1, tempCClass6);
		g.addEdge(tempCClass5, tempCClass6);
		g.addEdge(tempCClass1, tempCClass5);
		g.addEdge(tempCClass2, tempCClass5);
		g.addEdge(tempCClass4, tempCClass5);
		g.addEdge(tempCClass2, tempCClass3);
		g.addEdge(tempCClass2, tempCClass4);

		// Fig - 2 in notes
		/*
		 * CustomClass tempCClass1 = new CustomClass("R1", 2);
		 * g.addVertex(tempCClass1);
		 * 
		 * CustomClass tempCClass2 = new CustomClass("R2", 4);
		 * g.addVertex(tempCClass2);
		 * 
		 * CustomClass tempCClass3 = new CustomClass("R3", 6);
		 * g.addVertex(tempCClass3);
		 * 
		 * CustomClass tempCClass4 = new CustomClass("R4", 9);
		 * g.addVertex(tempCClass4);
		 * 
		 * CustomClass tempCClass5 = new CustomClass("R5", 10);
		 * g.addVertex(tempCClass5);
		 * 
		 * // add edges g.addEdge(tempCClass1, tempCClass2);
		 * g.addEdge(tempCClass1, tempCClass4); g.addEdge(tempCClass2,
		 * tempCClass4); g.addEdge(tempCClass4, tempCClass5);
		 * g.addEdge(tempCClass2, tempCClass5); g.addEdge(tempCClass2,
		 * tempCClass3); g.addEdge(tempCClass3, tempCClass5);
		 */

		// Fig -3 in notes (from wikipedia)
		/*
		 * CustomClass tempCClass1 = new CustomClass("R1", 2);
		 * g.addVertex(tempCClass1);
		 * 
		 * CustomClass tempCClass2 = new CustomClass("R2", 4);
		 * g.addVertex(tempCClass2);
		 * 
		 * CustomClass tempCClass3 = new CustomClass("R3", 6);
		 * g.addVertex(tempCClass3);
		 * 
		 * CustomClass tempCClass4 = new CustomClass("R4", 9);
		 * g.addVertex(tempCClass4);
		 * 
		 * CustomClass tempCClass5 = new CustomClass("R5", 10);
		 * g.addVertex(tempCClass5);
		 * 
		 * CustomClass tempCClass6 = new CustomClass("R6", 10);
		 * g.addVertex(tempCClass6);
		 * 
		 * // add edges g.addEdge(tempCClass1, tempCClass2);
		 * g.addEdge(tempCClass2, tempCClass3); g.addEdge(tempCClass3,
		 * tempCClass4); g.addEdge(tempCClass4, tempCClass5);
		 * g.addEdge(tempCClass5, tempCClass6); g.addEdge(tempCClass6,
		 * tempCClass1);
		 * 
		 * g.addEdge(tempCClass1, tempCClass3); g.addEdge(tempCClass3,
		 * tempCClass5); g.addEdge(tempCClass5, tempCClass1);
		 * 
		 * g.addEdge(tempCClass2, tempCClass4); g.addEdge(tempCClass4,
		 * tempCClass6); g.addEdge(tempCClass6, tempCClass2);
		 */

		// Fig -4 in notes (from wikipedia beginning)
		/*
		 * CustomClass tempCClass1 = new CustomClass("R1", 2);
		 * g.addVertex(tempCClass1);
		 * 
		 * CustomClass tempCClass2 = new CustomClass("R2", 4);
		 * g.addVertex(tempCClass2);
		 * 
		 * CustomClass tempCClass3 = new CustomClass("R3", 6);
		 * g.addVertex(tempCClass3);
		 * 
		 * CustomClass tempCClass4 = new CustomClass("R4", 9);
		 * g.addVertex(tempCClass4);
		 * 
		 * CustomClass tempCClass5 = new CustomClass("R5", 10);
		 * g.addVertex(tempCClass5);
		 * 
		 * CustomClass tempCClass6 = new CustomClass("R6", 10);
		 * g.addVertex(tempCClass6);
		 * 
		 * CustomClass tempCClass7 = new CustomClass("R7", 9);
		 * g.addVertex(tempCClass7);
		 * 
		 * CustomClass tempCClass8 = new CustomClass("R8", 10);
		 * g.addVertex(tempCClass8);
		 * 
		 * CustomClass tempCClass9 = new CustomClass("R9", 10);
		 * g.addVertex(tempCClass9);
		 * 
		 * CustomClass tempCClass10 = new CustomClass("R10", 10);
		 * g.addVertex(tempCClass10);
		 * 
		 * // add edges g.addEdge(tempCClass1, tempCClass2);
		 * g.addEdge(tempCClass2, tempCClass3); g.addEdge(tempCClass3,
		 * tempCClass4); g.addEdge(tempCClass4, tempCClass5);
		 * g.addEdge(tempCClass5, tempCClass1);
		 * 
		 * g.addEdge(tempCClass1, tempCClass6); g.addEdge(tempCClass2,
		 * tempCClass7); g.addEdge(tempCClass3, tempCClass8);
		 * g.addEdge(tempCClass4, tempCClass9); g.addEdge(tempCClass5,
		 * tempCClass10);
		 * 
		 * g.addEdge(tempCClass6, tempCClass8); g.addEdge(tempCClass8,
		 * tempCClass10); g.addEdge(tempCClass10, tempCClass7);
		 * g.addEdge(tempCClass7, tempCClass9); g.addEdge(tempCClass9,
		 * tempCClass6);
		 */

		// USA Map LEGENDARY
		/*
		 * CustomClass Alaska = new CustomClass("Alaska", 2);
		 * g.addVertex(Alaska);
		 * 
		 * CustomClass Hawaii = new CustomClass("Hawaii", 4);
		 * g.addVertex(Hawaii);
		 * 
		 * CustomClass Maine = new CustomClass("Maine", 2); g.addVertex(Maine);
		 * 
		 * CustomClass New_Hampshire = new CustomClass("New_Hampshire", 4);
		 * g.addVertex(New_Hampshire);
		 * 
		 * CustomClass Vermont = new CustomClass("Vermont", 6);
		 * g.addVertex(Vermont);
		 * 
		 * CustomClass Massachusets = new CustomClass("Massachusets", 9);
		 * g.addVertex(Massachusets);
		 * 
		 * CustomClass Rhode_Island = new CustomClass("Rhode_Island", 10);
		 * g.addVertex(Rhode_Island);
		 * 
		 * CustomClass Connecticut = new CustomClass("Connecticut", 10);
		 * g.addVertex(Connecticut);
		 * 
		 * CustomClass New_Jersey = new CustomClass("New_Jersey", 9);
		 * g.addVertex(New_Jersey);
		 * 
		 * CustomClass Delaware = new CustomClass("Delaware", 10);
		 * g.addVertex(Delaware);
		 * 
		 * CustomClass Maryland = new CustomClass("Maryland", 10);
		 * g.addVertex(Maryland);
		 * 
		 * CustomClass Washington_DC = new CustomClass("Washington_DC", 10);
		 * g.addVertex(Washington_DC);
		 * 
		 * CustomClass West_Virgina = new CustomClass("West_Virgina", 10);
		 * g.addVertex(West_Virgina);
		 * 
		 * CustomClass New_York = new CustomClass("New_York", 10);
		 * g.addVertex(New_York);
		 * 
		 * CustomClass Pennsylvania = new CustomClass("Pennsylvania", 10);
		 * g.addVertex(Pennsylvania);
		 * 
		 * CustomClass Virgina = new CustomClass("Virgina", 10);
		 * g.addVertex(Virgina);
		 * 
		 * CustomClass North_Carolina = new CustomClass("North_Carolina", 10);
		 * g.addVertex(North_Carolina);
		 * 
		 * CustomClass South_Carolina = new CustomClass("South_Carolina", 10);
		 * g.addVertex(South_Carolina);
		 * 
		 * CustomClass Georgia = new CustomClass("Georgia", 10);
		 * g.addVertex(Georgia);
		 * 
		 * CustomClass Florida = new CustomClass("Florida", 10);
		 * g.addVertex(Florida);
		 * 
		 * CustomClass Michigan = new CustomClass("Michigan", 10);
		 * g.addVertex(Michigan);
		 * 
		 * CustomClass Ohio = new CustomClass("Ohio", 10); g.addVertex(Ohio);
		 * 
		 * CustomClass Kentucky = new CustomClass("Kentucky", 10);
		 * g.addVertex(Kentucky);
		 * 
		 * CustomClass Tennessee = new CustomClass("Tennessee", 10);
		 * g.addVertex(Tennessee);
		 * 
		 * CustomClass Alabama = new CustomClass("Alabama", 10);
		 * g.addVertex(Alabama);
		 * 
		 * CustomClass Missisippi = new CustomClass("Missisippi", 10);
		 * g.addVertex(Missisippi);
		 * 
		 * CustomClass Lousiana = new CustomClass("Lousiana", 10);
		 * g.addVertex(Lousiana);
		 * 
		 * CustomClass Arkansas = new CustomClass("Arkansas", 10);
		 * g.addVertex(Arkansas);
		 * 
		 * CustomClass Indiana = new CustomClass("Indiana", 10);
		 * g.addVertex(Indiana);
		 * 
		 * CustomClass Illinois = new CustomClass("Illinois", 10);
		 * g.addVertex(Illinois);
		 * 
		 * CustomClass Missouri = new CustomClass("Missouri", 10);
		 * g.addVertex(Missouri);
		 * 
		 * CustomClass Iowa = new CustomClass("Iowa", 10); g.addVertex(Iowa);
		 * 
		 * CustomClass Wisconsin = new CustomClass("Wisconsin", 10);
		 * g.addVertex(Wisconsin);
		 * 
		 * CustomClass Minnesota = new CustomClass("Minnesota", 10);
		 * g.addVertex(Minnesota);
		 * 
		 * CustomClass North_Dakota = new CustomClass("North_Dakota", 10);
		 * g.addVertex(North_Dakota);
		 * 
		 * CustomClass South_Dakota = new CustomClass("South_Dakota", 10);
		 * g.addVertex(South_Dakota);
		 * 
		 * CustomClass Nebraska = new CustomClass("Nebraska", 10);
		 * g.addVertex(Nebraska);
		 * 
		 * CustomClass Kansas = new CustomClass("Kansas", 10);
		 * g.addVertex(Kansas);
		 * 
		 * CustomClass Oklahoma = new CustomClass("Oklahoma", 10);
		 * g.addVertex(Oklahoma);
		 * 
		 * CustomClass Texas = new CustomClass("Texas", 10); g.addVertex(Texas);
		 * 
		 * CustomClass Montana = new CustomClass("Montana", 10);
		 * g.addVertex(Montana);
		 * 
		 * CustomClass Wyoming = new CustomClass("Wyoming", 10);
		 * g.addVertex(Wyoming);
		 * 
		 * CustomClass Colorado = new CustomClass("Colorado", 10);
		 * g.addVertex(Colorado);
		 * 
		 * CustomClass New_Mexico = new CustomClass("New_Mexico", 10);
		 * g.addVertex(New_Mexico);
		 * 
		 * CustomClass Idaho = new CustomClass("Idaho", 10); g.addVertex(Idaho);
		 * 
		 * CustomClass Utah = new CustomClass("Utah", 10); g.addVertex(Utah);
		 * 
		 * CustomClass Arizona = new CustomClass("Arizona", 10);
		 * g.addVertex(Arizona);
		 * 
		 * CustomClass Washington = new CustomClass("Washington", 10);
		 * g.addVertex(Washington);
		 * 
		 * CustomClass Oregon = new CustomClass("Oregon", 10);
		 * g.addVertex(Oregon);
		 * 
		 * CustomClass Nevada = new CustomClass("Nevada", 10);
		 * g.addVertex(Nevada);
		 * 
		 * CustomClass California = new CustomClass("California", 10);
		 * g.addVertex(California);
		 * 
		 * // add edges g.addEdge(Maine, New_Hampshire); g.addEdge(Vermont,
		 * New_Hampshire); g.addEdge(Massachusets, New_Hampshire);
		 * g.addEdge(Vermont, Massachusets); g.addEdge(Vermont, New_York);
		 * g.addEdge(Rhode_Island, Massachusets); g.addEdge(Connecticut,
		 * Massachusets); g.addEdge(Connecticut, Rhode_Island);
		 * 
		 * g.addEdge(New_York, Massachusets); g.addEdge(New_York, Connecticut);
		 * g.addEdge(New_York, Pennsylvania); g.addEdge(New_Jersey,
		 * Pennsylvania); g.addEdge(New_Jersey, New_York);
		 * 
		 * g.addEdge(New_Jersey, Delaware); g.addEdge(Pennsylvania, Maryland);
		 * g.addEdge(Delaware, Maryland); g.addEdge(Delaware, Pennsylvania);
		 * g.addEdge(Ohio, Pennsylvania); g.addEdge(West_Virgina, Pennsylvania);
		 * g.addEdge(Virgina, Maryland); g.addEdge(Washington_DC, Maryland);
		 * 
		 * g.addEdge(Washington_DC, Virgina); g.addEdge(West_Virgina, Virgina);
		 * 
		 * g.addEdge(West_Virgina, Ohio); g.addEdge(West_Virgina, Kentucky);
		 * g.addEdge(Virgina, North_Carolina); g.addEdge(Virgina, Kentucky);
		 * g.addEdge(Virgina, Tennessee); g.addEdge(North_Carolina, Tennessee);
		 * g.addEdge(North_Carolina, South_Carolina); g.addEdge(North_Carolina,
		 * Georgia); g.addEdge(South_Carolina, Georgia);
		 * 
		 * g.addEdge(Kentucky, Tennessee); g.addEdge(Kentucky, Ohio);
		 * g.addEdge(Indiana, Ohio); g.addEdge(Michigan, Ohio);
		 * g.addEdge(Indiana, Kentucky); g.addEdge(Indiana, Michigan);
		 * g.addEdge(Georgia, Florida); g.addEdge(Georgia, Alabama);
		 * g.addEdge(Florida, Alabama);
		 * 
		 * g.addEdge(Missisippi, Alabama); g.addEdge(Tennessee, Alabama);
		 * g.addEdge(Tennessee, Missisippi); g.addEdge(Indiana, Illinois);
		 * g.addEdge(Wisconsin, Illinois); g.addEdge(Iowa, Illinois);
		 * g.addEdge(Wisconsin, Iowa); g.addEdge(Illinois, Missouri);
		 * g.addEdge(Kentucky, Missouri); g.addEdge(Tennessee, Missouri);
		 * g.addEdge(Tennessee, Arkansas); g.addEdge(Missisippi, Arkansas);
		 * 
		 * g.addEdge(Missisippi, Lousiana); g.addEdge(Arkansas, Lousiana);
		 * g.addEdge(Arkansas, Missouri); g.addEdge(Iowa, Missouri);
		 * g.addEdge(Iowa, Minnesota); g.addEdge(Arkansas,Oklahoma);
		 * g.addEdge(Arkansas,Texas); g.addEdge(Missouri,Oklahoma);
		 * 
		 * g.addEdge(Missouri,Kansas); g.addEdge(Missouri,Nebraska);
		 * g.addEdge(Iowa,South_Dakota); g.addEdge(Minnesota,South_Dakota);
		 * g.addEdge(Minnesota,North_Dakota);
		 * g.addEdge(South_Dakota,North_Dakota);
		 * g.addEdge(South_Dakota,Nebraska); g.addEdge(Kansas,Nebraska);
		 * g.addEdge(Texas,Oklahoma); g.addEdge(Texas,New_Mexico);
		 * g.addEdge(Oklahoma,New_Mexico); g.addEdge(Kansas, Colorado);
		 * g.addEdge(Nebraska, Colorado); g.addEdge(Nebraska, Wyoming);
		 * g.addEdge(South_Dakota, Wyoming); g.addEdge(South_Dakota, Montana);
		 * g.addEdge(North_Dakota, Montana); g.addEdge(Wyoming, Montana);
		 * g.addEdge(Wyoming, Colorado); g.addEdge(New_Mexico, Colorado);
		 * g.addEdge(New_Mexico, Arizona); g.addEdge(Utah, Arizona);
		 * g.addEdge(Utah, Colorado); g.addEdge(Utah,Wyoming);
		 * g.addEdge(Idaho,Wyoming); g.addEdge(Idaho,Montana);
		 * g.addEdge(Idaho,Utah); g.addEdge(Arizona, Nevada); g.addEdge(Utah,
		 * Nevada); g.addEdge(Idaho, Nevada); g.addEdge(Idaho, Washington);
		 * g.addEdge(Idaho, Oregon); g.addEdge(Washington, Oregon);
		 * g.addEdge(Nevada, Oregon); g.addEdge(California, Oregon);
		 * g.addEdge(California, Nevada); g.addEdge(California, Arizona);
		 */

		// Checked neighborretriver
		NeighborIndex myNeighborRetriever = new NeighborIndex(g);
		List<CustomClass> retrievedList = new ArrayList<>();
		// retrievedList = myNeighborRetriever.neighborListOf(tempCClass5);

		// retrieve all vertex
		Set<CustomClass> allVertex = new HashSet<CustomClass>();
		allVertex = g.vertexSet();

		// set all values to random out of TOTAL_AVAILABLE_COLORS
		for (CustomClass c : allVertex) {
			c.setValue(generateRandomValue(TOTAL_AVAILABLE_COLORS));
		}

		// Print the graph
		System.out.println(g.toString());

		//System.out.println("Calling the min-conflict algo !!");
		//soCalledMinConflict(g);
		
		System.out.println("Calling the FC with MRV !!");
		soCalledFCWithMRV(g);

		
		// Print the graph after algo
		System.out.println(g.toString());
	}

	private static void soCalledFCWithMRV(
			SimpleGraph<CustomClass, DefaultEdge> g2) {
		// TODO Auto-generated method stub
		
		tempFCMRVObj = getNodeWithMRV(g2);
		
	}

	private static CustomClass getNodeWithMRV(
			SimpleGraph<CustomClass, DefaultEdge> g2) {
		// TODO Auto-generated method stub
		CustomClass tempLocalMinObj;
		
		return null;
	}

	private static int generateRandomValue(int rangeMax) {
		Random rand = new Random();

		int randomNum = rand.nextInt(rangeMax);

		return randomNum;
	}

	private static void soCalledMinConflict(
			SimpleGraph<CustomClass, DefaultEdge> inputGraph) {
		boolean gotSolution = false;
		Random randomNodeGiver;
		for (int i = 0; i < MAX_STEPS; i++) {

			// Display if maximum step limit reached
			if (i == MAX_STEPS - 1) {
				System.out.println("Reahced limit");
			}

			if (checkIfSolutionIsFound(inputGraph)) {
				gotSolution = true;
				System.out.println("Steps taken to complete the algorithm : "
						+ i);

				break;
			}
			updateConflictingStatesInfo();

			// ///////TODO///////////////////////
			// getting random conflicted variable
			randomNodeGiver = new Random();
			tempConflictedObj = conflictedStates.get(randomNodeGiver
					.nextInt(conflictedStates.size()));
			// ////////////////////////////////////

			// Change its value to diff value which would minimize the conflict
			changeItsValue(tempConflictedObj);

		}

		// Print appropriate output
		if (gotSolution) {
			System.out.println("yoohoo");
		} else {
			System.out.println("Naaah");
		}
	}

	private static void changeItsValue(CustomClass inputConflictedObj) {
		// TODO Auto-generated method stub

		// neighbor index for this input object
		NeighborIndex neighborSupplierOfConflictedObj = new NeighborIndex(g);

		// Array to retrieve/record nearbr colors of neighbors - it will help in
		// choosing best color for current state
		List<Integer> populationOfNearbyColors = new ArrayList<Integer>(
				TOTAL_AVAILABLE_COLORS);

		// Creating empty list for saving the list of all neighbors
		List<CustomClass> retrievedNeighorsOfThisConflictedClass = new ArrayList<>();

		// Actually retrieving the neighbors
		retrievedNeighorsOfThisConflictedClass = neighborSupplierOfConflictedObj
				.neighborListOf(inputConflictedObj);

		// Initialize them to zero
		for (int i = 0; i < TOTAL_AVAILABLE_COLORS; i++) {
			populationOfNearbyColors.add(i, 0);
		}

		// Count the number of particular colors neighbors have
		for (CustomClass c : retrievedNeighorsOfThisConflictedClass) {
			populationOfNearbyColors.set(c.getValue(),
					populationOfNearbyColors.get(c.getValue()) + 1);
		}

		int indexOfMinimumValueAvailableNearby = populationOfNearbyColors
				.indexOf(Collections.min(populationOfNearbyColors));
		inputConflictedObj.setValue(indexOfMinimumValueAvailableNearby);

	}

	private static void updateConflictingStatesInfo() {
		Set<CustomClass> allVertexOfThisGraph = new HashSet<CustomClass>();
		allVertexOfThisGraph = g.vertexSet();
		conflictedStates = new ArrayList<>();
		for (CustomClass c : allVertexOfThisGraph) {
			if (c.isConflicted()) {
				conflictedStates.add(c);
			}

		}
	}

	private static boolean checkIfSolutionIsFound(
			SimpleGraph<CustomClass, DefaultEdge> iGraph) {
		// TODO Auto-generated method stub
		boolean conflict = false;
		Set<CustomClass> allVertexOfThisGraph = new HashSet<CustomClass>();
		allVertexOfThisGraph = iGraph.vertexSet();

		NeighborIndex myNeighborSupplier = new NeighborIndex(iGraph);
		List<CustomClass> retrievedNeighors = new ArrayList<>();

		int currentNodeValue = -100;
		int neighborNodeValue = -100;

		// set all values to random out of 4 (4 colors)
		for (CustomClass c : allVertexOfThisGraph) {

			currentNodeValue = c.getValue();
			retrievedNeighors = myNeighborSupplier.neighborListOf(c);
			for (CustomClass n : retrievedNeighors) {
				if (currentNodeValue == n.getValue()) {
					conflict = true;
					n.setConflicted(true);
					c.setConflicted(true);
				}
			}
		}
		return (!conflict);

	}
}
