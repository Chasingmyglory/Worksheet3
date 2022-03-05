/*
 * @Authors: George Naous, Mohammad Raisul Hasan Shamim, Azizul Hakim
 * @Date: 10.01.2022
 * Purpose: AdjacencyList class, to create a an adjacency linked list that contains edges of each vertex
 * implements an iterator
 */

package worksheet3;

import java.util.Iterator;
import java.util.LinkedList;

public class AdjacencyList implements Iterable<Integer> {			// constructor for AdjacencyList class
	private LinkedList<Integer> adjacencies;	// a linked list for adjacencies of a certain vertex
	private int id;		// the vertex that the list is created for
	
	@Override
	public String toString() {
		return "AdjacencyList [adjacencies=" + adjacencies + ", id=" + id + "]";
	}

	public AdjacencyList(int id) {
		this.id = id;
		adjacencies = new LinkedList<Integer>();
	}

	public int getId() {
		return id;
	}
	
	public int getId(int index) {  //for the modified painter
		id = index;
		return id;
	}
	
	public int size() {		// for the modifies painter
		return adjacencies.size();
	}

	public void add(int neighbour) {			// adds a neighbor to the adjacency list, creates an edge
		adjacencies.add(neighbour);
		
	}

	public boolean contains(int v) {			// checks if the adjacency list contains a certain vertex
		return adjacencies.contains(v);		
		}
	
	@Override
    public Iterator<Integer> iterator() {			// an iterator to iterate the adjacency list
        return new Iterator<Integer>() {
            private int index = 0;
            
            public boolean hasNext() {
                return index < adjacencies.size();
            }

            @Override
            public Integer next() {
                int current = adjacencies.get(index);
                index++;
                return current;
            }
        };
    }
	
}
