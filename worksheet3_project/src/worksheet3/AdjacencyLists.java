/*
 * @Authors: George Naous, Mohammad Raisul Hasan Shamim, Azizul Hakim
 * @Date: 10.01.2022
 * Purpose: AdjacencyLists class, to create a an ArrayList where each item is an adjacency linked list
 */

package worksheet3;
import java.util.ArrayList;

public class AdjacencyLists {
	private ArrayList<AdjacencyList> neighbourList;				// an ArrayList that contains all adjacency lists of the graph

	public AdjacencyLists(AdjacencyMatrix neighboursMatrix) {			// constructor for the AdjacencyLists
		neighbourList = new ArrayList<AdjacencyList>();
		for(int i = 0; i < neighboursMatrix.numOfVertices(); i++) {
			AdjacencyList aList = new AdjacencyList(i);
			for(int j = 0; j < neighboursMatrix.numOfVertices(); j++) {
				if(neighboursMatrix.get(i, j) == 1 || neighboursMatrix.get(j, i) == 1) {
					aList.add(j);
				}
			}
			neighbourList.add(aList);

		}
	}

	public AdjacencyList getNeighboursFor(int v) {			// returns a linked list of neighbors for a certain vertex
		return neighbourList.get(v); 
	}

}
