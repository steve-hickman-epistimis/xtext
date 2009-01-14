package org.eclipse.xtext.parsetree.reconstr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerUtil {
	public static void serialize(IParseTreeConstructor astSerializer,
			ITokenSerializer tokenSerializer, EObject obj, OutputStream out)
			throws IOException {
		tokenSerializer.serialize(astSerializer.serialize(obj), out);
	}

	public static void serialize(IServiceScope scope, EObject obj, OutputStream out)
			throws IOException {
		//TODO god kills a kitten every time you use ServiceRegistry directly! 
		IParseTreeConstructor astSer = ServiceRegistry.getService(scope,
				IParseTreeConstructor.class);
		ITokenSerializer tSer = ServiceRegistry.getService(scope,
				ITokenSerializer.class);
		serialize(astSer, tSer, obj, out);
	}

	public static String serialize(IServiceScope scope, EObject obj) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			serialize(scope, obj, out);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return out.toString();
	}

}
