//
// Client.java
//
// Copyright © 2017 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task08;

import akashivskyy.tpo.task08.remote.AddingRemote;
import akashivskyy.tpo.task08.remote.EchoingRemote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public final class Client {

	public static void main(String[] args) throws Exception {

		Registry registry = LocateRegistry.getRegistry(Configuration.PORT);

		AddingRemote addingRemote = (AddingRemote)registry.lookup(Configuration.ADDING_REMOTE_ID);
		EchoingRemote echoingRemote = (EchoingRemote)registry.lookup(Configuration.ECHOING_REMOTE_ID);

		System.out.println(String.format("RMI Client started at port %d.", Configuration.PORT));

		int addResult = addingRemote.add(1, 2);
		System.out.println(String.format("RMI Server responded to add: %d.", addResult));

		String echoResult = echoingRemote.echo("test");
		System.out.println(String.format("RMI Server responded to echo: %s.", echoResult));

	}

}
