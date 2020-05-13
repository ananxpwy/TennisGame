package main.java;

import java.util.Random;

import main.java.dto.Player;
import main.java.enums.ScoreEnum;

public class TennisGameController {

	private static final String WINNER = "WINNER :";
	private static final String DEUCE = "DEUCE";
	private static final String ADVANTAGE = "ADVANTAGE :";

	public static void main(String args[]) {
		Player playerOne = new Player("PCY", 0, false);
		Player playerTwo = new Player("OSH", 0, false);
		Boolean gameOver = false;

		while (!gameOver) {
			getScore(playerOne, playerTwo);
			gameOver = getResult(playerOne, playerTwo);
		}
	}

	private static Boolean getResult(Player playerOne, Player playerTwo) {

		Integer playerOneScore = playerOne.getScore();
		Integer playerTwoScore = playerTwo.getScore();

		if (hasWin(playerOneScore, playerTwoScore)) {
			System.out.println(WINNER + getWinnerName(playerOne, playerTwo));
			return true;
		}

		if (hasAdvantage(playerOneScore, playerTwoScore)) {
			System.out.println(ADVANTAGE + getWinnerName(playerOne, playerTwo));
			return false;
		}

		if (hasDeuce(playerOneScore, playerTwoScore)) {
			System.out.println(playerOne.getName() + " vs " + playerTwo.getName() + ": " + DEUCE);
			return false;
		}
		
		System.out.println(playerOne.getName() + " vs " + playerTwo.getName() + ": " 
				+ getScoreName(playerOneScore) + " vs " + getScoreName(playerTwoScore));
		return false;
	}

	private static boolean hasDeuce(Integer playerOneScore, Integer playerTwoScore) {
		return playerOneScore >= 3 && playerTwoScore >= 3 && playerOneScore == playerTwoScore;
	}

	private static boolean hasAdvantage(Integer playerOneScore, Integer playerTwoScore) {
		return playerOneScore >= 3 && playerTwoScore >= 3 && Math.abs(playerOneScore - playerTwoScore) == 1;
	}

	private static boolean hasWin(Integer playerOneScore, Integer playerTwoScore) {
		return (playerOneScore >= 4 || playerTwoScore >= 4) && Math.abs(playerOneScore - playerTwoScore) >= 2;
	}

	private static void getScore(Player playerOne, Player playerTwo) {
		Random random = new Random();
		Boolean isPlayerOneWinPoint = random.nextBoolean();
		if (isPlayerOneWinPoint) {
			playerOne.setScore(playerOne.getScore() + 1);
		} else {
			playerTwo.setScore(playerTwo.getScore() + 1);
		}
	}

	private static String getWinnerName(Player playerOne, Player playerTwo) {
		return (playerOne.getScore() > playerTwo.getScore()) ? playerOne.getName() : playerTwo.getName();
	}
	
	public static String getScoreName(Integer value) {
		switch (value) {
		case 3:
			return ScoreEnum.FORTY.name();
		case 2:
			return ScoreEnum.THIRTY.name();
		case 1:
			return ScoreEnum.FIFTEEN.name();
		case 0:
			return ScoreEnum.LOVE.name();
		}
		return value.toString();
	}

}
