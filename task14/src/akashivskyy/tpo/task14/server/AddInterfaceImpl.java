//
// AddInterfaceImpl.java
//
// Copyright © 2018 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task14.server;

import akashivskyy.tpo.task14.generated.AddInterfacePOA;

public final class AddInterfaceImpl extends AddInterfacePOA {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

}
