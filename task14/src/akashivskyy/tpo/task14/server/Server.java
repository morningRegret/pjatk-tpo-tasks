//
// Server.java
//
// Copyright © 2018 Adrian Kashivskyy. All rights reserved.
//

package akashivskyy.tpo.task14.server;

import akashivskyy.tpo.task14.Configuration;
import akashivskyy.tpo.task14.generated.AddInterface;
import akashivskyy.tpo.task14.generated.AddInterfaceHelper;
import akashivskyy.tpo.task14.generated.EchoInterface;
import akashivskyy.tpo.task14.generated.EchoInterfaceHelper;
import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public final class Server {

	public static void main(String[] args) throws Exception {

		Properties orbProperties = new Properties();
		orbProperties.put("org.omg.CORBA.ORBInitialPort", Integer.toString(Configuration.PORT));

		ORB orb = ORB.init(args, orbProperties);

		POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootPoa.the_POAManager().activate();

		AddInterfaceImpl addImpl = new AddInterfaceImpl();
		EchoInterfaceImpl echoImpl = new EchoInterfaceImpl();

		AddInterface addInterface = AddInterfaceHelper.narrow(rootPoa.servant_to_reference(addImpl));
		EchoInterface echoInterface = EchoInterfaceHelper.narrow(rootPoa.servant_to_reference(echoImpl));

		NamingContextExt naming = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
		naming.rebind(naming.to_name(Configuration.ADD_SERVICE_NAME), addInterface);
		naming.rebind(naming.to_name(Configuration.ECHO_SERVICE_NAME), echoInterface);

		System.out.println(String.format("Started CORBA server at port %d.", Configuration.PORT));

		orb.run();

	}

}
