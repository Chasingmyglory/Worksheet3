/*
 * @Authors: George Naous, Mohammad Raisul Hasan Shamim, Azizul Hakim
 * @Date: 10.01.2022
 * Purpose: AdjacencyMatrix class, to create a a 2D array that represents edges between vertices
 * 1 means there is an edge and 0 means there is not
 */


package worksheet3;

public class AdjacencyMatrix {

	private int adjMatrix[][];

	public AdjacencyMatrix(int[][] adjMatrix) {				// constructor for the adjacency matrix
		this.adjMatrix = adjMatrix;
	}

	public int get(int v, int u) {				// returns an integer (1 or 0) for a combination of 2 nodes to check for edges
		return adjMatrix[v][u];
	}

	public int numOfVertices() {				// returns the number of vertices (nodes) in the graph
		return adjMatrix.length;
	}
	
}
