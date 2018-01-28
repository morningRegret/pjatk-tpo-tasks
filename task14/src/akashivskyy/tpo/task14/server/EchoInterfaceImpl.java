//
// EchoInterfaceImpl.java
//
// Copyright © 2018 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task14.server;

import akashivskyy.tpo.task14.generated.EchoInterfacePOA;

public final class EchoInterfaceImpl extends EchoInterfacePOA {

	@Override
	public String echo(String message) {
		return message;
	}

}
