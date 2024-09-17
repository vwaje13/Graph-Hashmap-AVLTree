
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; 
public class VeerWajeAssignment3 {
	public static void main(String[] args) {
		
		//basic arrays to store cities and distances
		String[] city1 = new String[72];
		String[] city2 = new String[72];
		double[] distance = new double[72];
		
		try {	
            
			//buffered reader to read values from the file
			BufferedReader reader = new BufferedReader(new FileReader("Assignment3Data.txt"));
            
            String line;
            int i = 0;
            //splitting each line by tabs
            while ((line = reader.readLine()) != null) {
            	//adding each segment of each line into their respective arrays
            	String[] parts = line.split("\t"); 
                city1[i] = parts[0];
                city2[i] = parts[1];
                distance[i] = Double.parseDouble(parts[2]);
                i++;
            }

            reader.close();
        } catch (IOException e) {
        	//catching file not found exception
            System.out.println("Error reading the file: " + e.getMessage());
        }
		
		//Creating instances of BST and AVLT
		VeerWajeBinarySearchTree<Double> myVeerWajeBST = new VeerWajeBinarySearchTree<Double>();
		VeerWajeAVLTree<Double> myVeerWajeAVLT = new VeerWajeAVLTree<Double>();
		
		//Inserting values from the distance array into BST and AVLT
		for(int i = 0; i < distance.length; i++) {
			myVeerWajeBST.insert(distance[i]);
			myVeerWajeAVLT.insert(distance[i]);
		}
		
		//Searching BST and AVLT
		System.out.println(myVeerWajeBST.search(595.));
		System.out.println(myVeerWajeAVLT.search(595.));
		
		//Postorder BST and AVLT
		myVeerWajeBST.postorder();
		System.out.println();
		myVeerWajeAVLT.postorder();
		System.out.println();
		
		//Preorder BST and AVLT
		myVeerWajeBST.preorder();
		System.out.println();
		myVeerWajeAVLT.preorder();
		System.out.println();
		
		//getSize BST and AVLT
		System.out.println(myVeerWajeBST.getSize());
		System.out.println(myVeerWajeAVLT.getSize());
		
		//getroot BST and AVLT
		System.out.println(myVeerWajeBST.getRoot());
		System.out.println(myVeerWajeAVLT.getRoot());
		
		//path BST and AVLT
		System.out.println(myVeerWajeBST.path(460.));
		System.out.println(myVeerWajeAVLT.path(460.));
		
		//delete BST and AVLT
		System.out.println(myVeerWajeBST.delete(460.));
		System.out.println(myVeerWajeAVLT.delete(460.));
		
		//clear BST and AVLT
		myVeerWajeBST.clear();
		myVeerWajeAVLT.clear();
		
		//inorder BST and AVLT
		myVeerWajeBST.inorder();
		System.out.println();
		myVeerWajeAVLT.inorder();
		
		//Creating instance of HS
		VeerWajeHashSet<String> myVeerWajeHS = new VeerWajeHashSet<String>();
		
		// adding city1 Strings to HS
		for(int i = 0; i < city1.length; i++) {
			myVeerWajeHS.add(city1[i]);
		}
		
		//contains HS
		System.out.println(myVeerWajeHS.contains("Baltimore"));
		
		//Size HS
		System.out.println(myVeerWajeHS.size());
		
		//checks if empty
		System.out.println(myVeerWajeHS.isEmpty());
		
		//removes baltimore
		myVeerWajeHS.remove("Baltimore");
		
		//prints the HS as a string
		System.out.println(myVeerWajeHS.toString());
		
		//prints the array version of this HS
		System.out.println(myVeerWajeHS.toArray().toString());
		
		//clears the HS
		myVeerWajeHS.clear();
		
		//Create an instance of hashmap using city2 and distance
		VeerWajeHashMap<Double, String> myVeerWajeHM = new VeerWajeHashMap<Double, String>();
		
		//adds the values from the city2 arr and distance arr to the hashmap
		for(int i = 0; i < city1.length; i++) {
			myVeerWajeHM.put(distance[i], city2[i]);
		}
		
		//print size HM
		System.out.println(myVeerWajeHM.size());
		
		//remove 212 key HM
		myVeerWajeHM.remove(212.);
		
		//tostring HM
		System.out.println(myVeerWajeHM.toString());
		
		//print values of HM
		System.out.println(myVeerWajeHM.values().toString());
		
		//print keys of HM
		System.out.println(myVeerWajeHM.keySet().toString());
		
		//print entries of HM
		System.out.println(myVeerWajeHM.entrySet().toString());
		
		//return the value associated with key 572 (should be washington)
		System.out.println(myVeerWajeHM.get(572.));
		
		//congains 572 key?
		System.out.println(myVeerWajeHM.containsKey(572.));
		
		//contains washington?
		System.out.println(myVeerWajeHM.containsValue("Washington"));
		
		//clears the HM
		myVeerWajeHM.clear();
		
		//returns true because we just cleared the HM
		System.out.println(myVeerWajeHM.isEmpty());
		
		
		//create a WG
		VeerWajeWeightedGraph<String> myVeerWajeWG = new VeerWajeWeightedGraph<String>();
		

	}

}
