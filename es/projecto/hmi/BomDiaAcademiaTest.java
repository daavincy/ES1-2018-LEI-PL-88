/**
 * 
 */
package es.projecto.hmi;

import static org.junit.Assert.assertNotNull;

/**
 * @author Elvino Monteiro
 *
 */
public class BomDiaAcademiaTest {
	
	void initializeGUI() {
		BomDiaAcademia bda = new BomDiaAcademia(new HMIPresenterImpl());
				assertNotNull(bda);
	}

}
