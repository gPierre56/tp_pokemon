package fr.diginamic.main;

import java.util.Scanner;

import fr.diginamic.utils.ConnectionManager;

public class Main {

	public static void main(String[] args) {

		try {
			Class.forName(ConnectionManager.getDriver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner sc = new Scanner(System.in);

		System.out.println("Pokemon go");
		String choix = "";

		while (!choix.contentEquals("99")) {

		}

	}

}
