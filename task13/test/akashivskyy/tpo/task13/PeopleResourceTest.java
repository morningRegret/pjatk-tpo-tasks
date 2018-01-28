//
// PeopleResourceTest.java
//
// Copyright © 2018 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task13;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public final class PeopleResourceTest extends JerseyTest {

	private Map<String, String> fooBarMap;
	private Map<String, String> bazQuxMap;

	@Before
	public void setUp() throws Exception {

		fooBarMap = new HashMap<>();
		fooBarMap.put("firstName", "Foo");
		fooBarMap.put("lastName", "Bar");
		fooBarMap.put("dateOfBirth", "2001-02-03");

		bazQuxMap = new HashMap<>();
		bazQuxMap.put("firstName", "Baz");
		bazQuxMap.put("lastName", "Qux");
		bazQuxMap.put("dateOfBirth", "2004-05-06");

		super.setUp();

	}

	@Override
	public Application configure() {
		return new ResourceConfig(PeopleResource.class);
	}

	@Test
	public void testGetAll() throws Exception {
		List response = target("people").request().get(List.class);
		List expected = Arrays.asList(fooBarMap, bazQuxMap);
		Assert.assertEquals(response, expected);
	}

	@Test
	public void testGetAllWithCorrectLastName() throws Exception {
		List response = target("people").queryParam("ln", "ba").request().get(List.class);
		List expected = Collections.singletonList(fooBarMap);
		Assert.assertEquals(response, expected);
	}

	@Test
	public void testGetAllWithIncorrectLastName() throws Exception {
		List response = target("people").queryParam("ln", "fo").request().get(List.class);
		List expected = Collections.emptyList();
		Assert.assertEquals(response, expected);
	}

	@Test
	public void testGetAllWithCorrectYearOfBirth() throws Exception {
		List response = target("people").queryParam("y", "2001").request().get(List.class);
		List expected = Collections.singletonList(fooBarMap);
		Assert.assertEquals(response, expected);
	}

	@Test
	public void testGetAllWithIncorrectYearOfBirth() throws Exception {
		List response = target("people").queryParam("y", "2003").request().get(List.class);
		List expected = Collections.emptyList();
		Assert.assertEquals(response, expected);
	}

	@Test
	public void testGetAllWithCorrectMonthOfBirth() throws Exception {
		List response = target("people").queryParam("m", "2").request().get(List.class);
		List expected = Collections.singletonList(fooBarMap);
		Assert.assertEquals(response, expected);
	}

	@Test
	public void testGetAllWithIncorrectMonthOfBirth() throws Exception {
		List response = target("people").queryParam("m", "8").request().get(List.class);
		List expected = Collections.emptyList();
		Assert.assertEquals(response, expected);
	}

	@Test
	public void testGetAllWithCorrectDayOfBirth() throws Exception {
		List response = target("people").queryParam("d", "3").request().get(List.class);
		List expected = Collections.singletonList(fooBarMap);
		Assert.assertEquals(response, expected);
	}

	@Test
	public void testGetAllWithIncorrectDayOfBirth() throws Exception {
		List response = target("people").queryParam("d", "9").request().get(List.class);
		List expected = Collections.emptyList();
		Assert.assertEquals(response, expected);
	}

	@Test
	public void testGetAllWithCorrectDateOfBirth() throws Exception {
		List response = target("people").queryParam("y", "2004").queryParam("m", "5").queryParam("d", "6").request().get(List.class);
		List expected = Collections.singletonList(bazQuxMap);
		Assert.assertEquals(response, expected);
	}

	@Test
	public void testGetAllWithIncorrectDateOfBirth() throws Exception {
		List response = target("people").queryParam("y", "2004").queryParam("m", "6").queryParam("d", "5").request().get(List.class);
		List expected = Collections.emptyList();
		Assert.assertEquals(response, expected);
	}

}
