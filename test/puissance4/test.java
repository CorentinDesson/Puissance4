package tp5;

import static org.junit.Assert.*;

import org.junit.Test;

import puissance4.App;

public class Exe1Test {

	@Test
	public void testCopieTableau() {
		int[] t = { 1, 0, 6, 8, 6, 9, 2, 2, 6 };
		int[] t2 = App.copieTableau(t);
		assertArrayEquals(t, t2); // Vérifie que les deux tableaux t et t2 sont identiques
		assertEquals(false, t == t2); // Vérifie qu'il s'agit de deux tableaux différents en mémoire
	}