//
// Client.java
//
// Copyright © 2018 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task14.client;

import akashivskyy.tpo.task14.Configuration;
import akashivskyy.tpo.task14.generated.AddInterface;
import akashivskyy.tpo.task14.generated.AddInterfaceHelper;
import akashivskyy.tpo.task14.generated.EchoInterface;
import akashivskyy.tpo.task14.generated.EchoInterfaceHelper;
import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public final class Client {

	public static void main(String[] args) throws Exception {

		Properties orbProperties = new Properties();
		orbProperties.put("org.omg.CORBA.ORBInitialPort", Integer.toString(Configuration.PORT));

		ORB orb = ORB.init(args, orbProperties);

		NamingContextExt naming = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));

		AddInterface addInterface = AddInterfaceHelper.narrow(naming.resolve_str(Configuration.ADD_SERVICE_NAME));
		EchoInterface echoInterface = EchoInterfaceHelper.narrow(naming.resolve_str(Configuration.ECHO_SERVICE_NAME));

		System.out.println(String.format("Started CORBA client at %d.", Configuration.PORT));

		int addResponse = addInterface.add(2, 3);
		System.out.println(String.format("Sent %s.add(2, 3). Response: %d.", Configuration.ADD_SERVICE_NAME, addResponse));

		String echoResponse = echoInterface.echo("foobar");
		System.out.println(String.format("Sent %s.echo(\"foobar\"). Response: \"%s\".", Configuration.ECHO_SERVICE_NAME, echoResponse));

	}

}
