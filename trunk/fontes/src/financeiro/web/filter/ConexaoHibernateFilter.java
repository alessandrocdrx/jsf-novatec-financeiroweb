package financeiro.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.hibernate.SessionFactory;

import financeiro.util.HibernateUtil;

public class ConexaoHibernateFilter implements Filter {

	private SessionFactory sf;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
	}

	public void doFilter(javax.servlet.ServletRequest servletRequest,
			javax.servlet.ServletResponse servletResponse,
			javax.servlet.FilterChain chain) throws java.io.IOException,
			ServletException {
		try {
			this.sf.getCurrentSession().beginTransaction();
			chain.doFilter(servletRequest, servletResponse);
			this.sf.getCurrentSession().getTransaction().commit();
			this.sf.getCurrentSession().close();
		} catch (Throwable ex) {
			try {
				if (this.sf.getCurrentSession().getTransaction().isActive()) {
					this.sf.getCurrentSession().getTransaction().rollback();
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
	}

	@Override
	public void destroy() {
	}
}
