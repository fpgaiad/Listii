package br.com.fpgaiad.cleanmvp.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    List<String> list;

    public List<String> addToList(String task) {
        if (list == null) {
            list = new ArrayList<>();
            list.add(task);
        } else {
            list.add(task);
        }
        return list;
    }
//            list.add("Ligar para amigo");
//            list.add("Agendar médico");
//            list.add("Supermercado comprar comidaaa!");
//            list.add("Intencionalmente pequeno o espaço...");
//            list.add("justamente para forçar usuário...");
//            list.add("a usar a criatividade para...");
//            list.add("inserir apenas tópicos...");
//            list.add("que remetam à tarefa");
//            list.add("what's happening here?");
//            list.add("01234567890123456789012345678901234567890123456789");
//            list.add("Portanto, são 30 caracteres no total!");
}
