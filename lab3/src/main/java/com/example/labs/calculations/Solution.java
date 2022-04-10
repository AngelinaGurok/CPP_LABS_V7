package com.example.labs.calculations;

import com.example.labs.SpringConfig;
import com.example.labs.cache.Cache;
import com.example.labs.logger.ProgramLogger;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Solution {
    private final Cache cache;

    private final Parametres parametres;

    private Integer root;

    public Solution(Parametres params) {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        cache = context.getBean("cache", Cache.class);
        context.close();

        this.parametres = params;
    }

    public void calculateRoot() {
        var temp = cache.find(parametres);
        if (temp != null) {
            ProgramLogger.log(Level.WARN, "Value found in cache!");
            setRoot(temp);

            return;
        }

        if(parametres.getOperationValue().equals("s")){
            temp = parametres.getAValue() + parametres.getBValue();
        }
        else if (parametres.getOperationValue().equals("m")) {
            temp = parametres.getAValue() * parametres.getBValue();
        }
        setRoot(temp);

        cache.add(parametres, root);
    }

    public Integer getRoot() {
        return root;
    }

    public void  setRoot(@Nullable Integer root) {
        this.root = root;
    }
}
