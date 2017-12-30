//
// AddingEchoingRemote.java
//
// Copyright © 2017 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task08.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public final class AddingEchoingRemote extends UnicastRemoteObject implements AddingRemote, EchoingRemote {

	public AddingEchoingRemote() throws RemoteException {}

	@Override
	public int add(int a, int b) throws RemoteException {
		return a + b;
	}

	@Override
	public String echo(String string) throws RemoteException {
		return string;
	}

}
