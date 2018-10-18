package es.projecto.hmi;

public class BDAHmi {

	/**
	 * @author a24227
	 * first method to show the usage of the test cases.
	 * 
	 * @param tree, the female name of the tree from where the bananas came frome
	 * @return a {@link Boolean} stating if the tree gives bananas
	 */
	public Boolean doBananas(String tree) {
		if(tree.equals("Bananeira")) {
			return true;
		}
		return false;
		
	}
}
