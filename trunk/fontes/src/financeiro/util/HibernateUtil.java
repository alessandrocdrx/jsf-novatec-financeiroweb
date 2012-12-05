package financeiro.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Configuration cfg = new Configuration().configure();
			// cfg.configure("hibernate.cfg.xml");

			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure();
			return cfg.buildSessionFactory();
		} catch (Throwable e) {
			System.out
					.println("Criação inicial do objeto SessionFactory falhou. Erro: "
							+ e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
