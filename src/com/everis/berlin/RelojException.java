package com.everis.berlin;

import java.util.ArrayList;

public class RelojException extends Exception {

	public RelojException(ArrayList<String> messages) {
		super(messages.toString());
	}
}
