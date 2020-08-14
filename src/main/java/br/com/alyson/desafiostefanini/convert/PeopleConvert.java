package br.com.alyson.desafiostefanini.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.ServletContext;

import br.com.alyson.desafiostefanini.model.People;
import br.com.alyson.desafiostefanini.service.PeopleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


@FacesConverter(forClass = People.class)
public class PeopleConvert implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        People retorno = null;

        ApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext((ServletContext) FacesContext
                        .getCurrentInstance().getExternalContext()
                        .getContext());
        PeopleService peopleService = ctx.getBean(PeopleService.class);

        if (StringUtils.isNotEmpty(value)) {
            Long id = new Long(value);
            retorno = peopleService.findById(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            People people = (People) value;
            return people.getId() == null ? null : people.getId().toString();
        }

        return "";
    }

}