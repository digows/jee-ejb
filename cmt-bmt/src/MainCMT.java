import java.util.List;
import java.util.Properties;

import javax.ejb.EJBException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.cesufoz.ejb.jpa.entity.Cargo;
import br.edu.cesufoz.ejb.jpa.service.cmt.CMTService;
import br.edu.cesufoz.ejb.jpa.service.cmt.CMTServiceRemote;

public class MainCMT {
	public static void main(String[] args) throws NamingException {
		
		final Properties properties = new Properties();
		//possibilita o acesso ao namespace "ejb:"
		properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(properties);
		
        final String componentName = "ejb:/ejb-jpa.web//" + CMTService.class.getSimpleName() + "!" + CMTServiceRemote.class.getName();
        
        //faz o lookup
        final CMTServiceRemote service = (CMTServiceRemote) context.lookup(componentName);
        
		service.requiredToRequireNewTest();
		System.out.println("RequireNew OK");
		
        try {
        	service.rollbackTest();
		} catch (EJBException e) {
			System.out.println("Rollback OK");
		}
        final List<Cargo> list = service.list();
		System.out.println(list);

		
		try {
			service.mandatoryTest();
		} catch (javax.ejb.EJBTransactionRequiredException e) {
			System.out.println("Mandatory OK");
		}
	}
}
