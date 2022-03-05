/*
 * @Authors: George Naous, Mohammad Raisul Hasan Shamim, Azizul Hakim
 * @Date: 10.01.2022
 * Purpose: Graph class, to create a graph structure for storing connected data
 * the graph consists of vertices and edges to represent connections between data entities (integers in this case)
 */

package worksheet3;


public class Graph {
	private AdjacencyMatrix neighboursMatrix;
	private AdjacencyLists neighboursLists;
	private int[][] adjMatrix;

	public Graph(int[][] adjMatrix) {			// graph constructor, initializes the graph's attributes
		this.adjMatrix = adjMatrix;
		neighboursMatrix = new AdjacencyMatrix(adjMatrix);
		neighboursLists = new AdjacencyLists(neighboursMatrix);
	}

	public AdjacencyList getNeighboursFor(int v) {
		return neighboursLists.getNeighboursFor(v);
	}

	public int numOfVertices() {			// returns the number of vertices or nodes in the graph
		return neighboursMatrix.numOfVertices();
	}

	public int numOfEdges() {			// returns the number of edges in the graph
		int edges = 0;
		for(int i = 0; i < adjMatrix.length; i++) {			// nested for-loops to traverse through the matrix and sum up the edges
			for(int j = 0; j < adjMatrix.length; j++) {
				if(adjMatrix[i][j] == 1) {
					edges++;
				}
			}
		}
		return edges;
	}

	public int getWeight(int u, int v) {
		return neighboursMatrix.get(u, v);
	}

	public AdjacencyList somePath(int u, int length) {	// algorithm that creates a path from a starting point, returns an AdjacencyList
		int l = 0;
		int i = u; // loop variable
		int j; // loop variable
		
		AdjacencyList sPath = new AdjacencyList(u);		// created an AdjacencyList for thr path
        int[][] visited = new int[adjMatrix.length][adjMatrix.length];	// a 2D array to check if a connection has been visited		
        // a loop to add nodes to the list until we reach the set length
        while(l < length) {
        	AdjacencyList adList = this.getNeighboursFor(i);
        	for(j = 0; j < adjMatrix.length; j++ ) {
        		// conditions: length not reached & there is an adjacency & connection has not been visited
	        	if(l < length && adList.contains(j) && i != j && ((neighboursMatrix.get(i, j) == 1) || (neighboursMatrix.get(j, i) == 1)) && (visited[i][j] != 1)) {
					sPath.add(j);		// adds a node to the path
					l++;
					visited[i][j] = 1;		// to mark a connection has been visited
					visited[j][i] = 1;		// to mark a connection has been visited
					i = j;
					break;
	        		}
        		}
        	}
        	return sPath;
		}

}
