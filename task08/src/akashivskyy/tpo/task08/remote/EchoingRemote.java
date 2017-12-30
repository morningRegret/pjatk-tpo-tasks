//
// EchoingRemote.java
//
// Copyright © 2017 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task08.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoingRemote extends Remote {

	public String echo(String string) throws RemoteException;

}
