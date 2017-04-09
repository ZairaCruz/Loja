package persistencia;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory(){
		try{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
			
			registradorServico.applySettings(cfg.getProperties());
			StandardServiceRegistry servico = registradorServico.build();
						
			return cfg.buildSessionFactory(servico);
		}catch(Throwable ex){
			System.out.println("Criação inicial do objeto SessionFactory falhou. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

}