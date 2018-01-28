//
// Person.java
//
// Copyright © 2018 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task13;

import java.time.LocalDate;

public final class Person {

	public Person(String firstName, String lastName, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public Person(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		this(firstName, lastName, LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth));
	}

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

}
