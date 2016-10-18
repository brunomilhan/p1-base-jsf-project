package inscricao.faces.mngbeans;

import inscricao.entity.Candidato;
import utfpr.faces.support.PageBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 18/10/2016.
 */
@Named
@ApplicationScoped
public class RegistroBean extends PageBean {

    private List<Candidato> candidatoList;

    public RegistroBean(){
        candidatoList = new ArrayList<>();
    }

    public void save(Candidato candidato){
        candidatoList.add(candidato);
    }

    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }
}