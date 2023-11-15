package org.example.structure.facade;

public class GovernmentFacade {

    private Police police = new Police();

    private Education education = new Education();

    private Social social = new Social();

    public void handleAll(String name) {
        police.register(name);
        education.assign(name);
        social.social(name);
    }

    //只做一部分
    public void handlePolice(String name) {
        police.register(name);
    }
}
