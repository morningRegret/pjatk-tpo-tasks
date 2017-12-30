//
// Server.java
//
// Copyright © 2017 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task08;

import akashivskyy.tpo.task08.remote.AddingEchoingRemote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public final class Server {

	public static void main(String[] args) throws Exception {

		Registry registry = LocateRegistry.createRegistry(Configuration.PORT);
		AddingEchoingRemote remote = new AddingEchoingRemote();

		registry.bind(Configuration.ADDING_REMOTE_ID, remote);
		registry.bind(Configuration.ECHOING_REMOTE_ID, remote);

		System.out.print(String.format("RMI Server started at port %d.", Configuration.PORT));

	}

}
