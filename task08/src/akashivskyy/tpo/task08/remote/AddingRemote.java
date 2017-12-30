//
// AddingRemote.java
//
// Copyright © 2017 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task08.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddingRemote extends Remote {

	public int add(int a, int b) throws RemoteException;

}
