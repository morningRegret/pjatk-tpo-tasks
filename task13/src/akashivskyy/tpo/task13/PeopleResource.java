//
// PeopleResource.java
//
// Copyright © 2018 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task13;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/people")
public final class PeopleResource {

	public PeopleResource() {
		this.people = Arrays.asList(
			new Person("Foo", "Bar", 2001, 2, 3),
			new Person("Baz", "Qux", 2004, 5, 6)
		);
	}

	private List<Person> people;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll(@QueryParam("ln") String lastName, @QueryParam("y") int yearOfBirth, @QueryParam("m") int monthOfBirth, @QueryParam("d") int dayOfBirth) {

		final Optional<String> parsedLastName;
		if (lastName != null) {
			parsedLastName = Optional.of(lastName.toLowerCase());
		} else {
			parsedLastName = Optional.empty();
		}

		Predicate<Person> lastNamePredicate = person -> {
			return parsedLastName.map(x -> person.getLastName().toLowerCase().contains(x)).orElse(true);
		};

		final Optional<Integer> parsedYearOfBirth;
		if (yearOfBirth != 0) {
			parsedYearOfBirth = Optional.of(yearOfBirth);
		} else {
			parsedYearOfBirth = Optional.empty();
		}

		Predicate<Person> yearOfBirthPredicate = person -> {
			return parsedYearOfBirth.map(x -> person.getDateOfBirth().getYear() == x).orElse(true);
		};

		final Optional<Integer> parsedMonthOfBirth;
		if (monthOfBirth != 0) {
			parsedMonthOfBirth = Optional.of(monthOfBirth);
		} else {
			parsedMonthOfBirth = Optional.empty();
		}

		Predicate<Person> monthOfBirthPredicate = person -> {
			return parsedMonthOfBirth.map(x -> person.getDateOfBirth().getMonthValue() == x).orElse(true);
		};

		final Optional<Integer> parsedDayOfBirth;
		if (dayOfBirth != 0) {
			parsedDayOfBirth = Optional.of(dayOfBirth);
		} else {
			parsedDayOfBirth = Optional.empty();
		}

		Predicate<Person> dayOfBirthPredicate = person -> {
			return parsedDayOfBirth.map(x -> person.getDateOfBirth().getDayOfMonth() == x).orElse(true);
		};

		return people.stream()
			.filter(lastNamePredicate)
			.filter(yearOfBirthPredicate)
			.filter(monthOfBirthPredicate)
			.filter(dayOfBirthPredicate)
			.collect(Collectors.toList());

	}

}
