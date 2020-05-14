package main.java.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.TennisGameController;
import main.java.dto.Player;

public class TennisGameControllerTest {

	private TennisGameController tennisGameController;
	
	@Test
	public void testGetResult_With_RetourTrue() {
		// given
		Player mockPlayerOne = new Player("PCY", 6);
		Player mockPlayerTwo = new Player("OSH", 4);

		// then
		Boolean actuel = tennisGameController.getResult(mockPlayerOne, mockPlayerTwo);
		assertTrue(actuel);
	}
	
	@Test
	public void testGetResult_With_RetourFalse_Advantage() {
		// given
		Player mockPlayerOne = new Player("PCY", 6);
		Player mockPlayerTwo = new Player("OSH", 5);

		// then
		Boolean actuel = tennisGameController.getResult(mockPlayerOne, mockPlayerTwo);
		assertFalse(actuel);
	}
	
	@Test
	public void testGetResult_With_RetourFalse_DEUCE() {
		// given
		Player mockPlayerOne = new Player("PCY", 5);
		Player mockPlayerTwo = new Player("OSH", 5);

		// then
		Boolean actuel = tennisGameController.getResult(mockPlayerOne, mockPlayerTwo);
		assertFalse(actuel);
	}
	
	@Test
	public void testGetResult_With_RetourFalse() {
		// given
		Player mockPlayerOne = new Player("PCY", 3);
		Player mockPlayerTwo = new Player("OSH", 2);

		// then
		Boolean actuel = tennisGameController.getResult(mockPlayerOne, mockPlayerTwo);
		assertFalse(actuel);
	}
}
