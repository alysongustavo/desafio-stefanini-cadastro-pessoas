package br.com.alyson.desafiostefanini.repository.helper;

import br.com.alyson.desafiostefanini.repository.filter.PeopleFilter;
import br.com.alyson.desafiostefanini.model.People;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PeopleRepositoryImpl implements PeopleQueries {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<People> filtrar(PeopleFilter filter) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(People.class);

        adicionarFiltro(filter, criteria);

        return criteria.list();
    }

    private void adicionarFiltro(PeopleFilter filter, Criteria criteria) {

        if (filter != null) {
            if (!StringUtils.isEmpty(filter.getCpf())) {
                criteria.add(Restrictions.eq("cpf", filter.getCpf()));
            }

            if (!StringUtils.isEmpty(filter.getName())) {
                criteria.add(Restrictions.ilike("name", filter.getName(), MatchMode.ANYWHERE));
            }

            if (!StringUtils.isEmpty(filter.getSex())) {
                criteria.add(Restrictions.eq("sex", filter.getSex()));
            }

            if (!StringUtils.isEmpty(filter.getNaturalness())) {
                criteria.add(Restrictions.eq("naturalness", filter.getNaturalness()));
            }

        }
    }
}
