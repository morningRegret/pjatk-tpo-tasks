//
// Application.java
//
// Copyright © 2018 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task13;

import java.util.Collections;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public final class PeopleApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return Collections.singleton(PeopleResource.class);
	}

}
