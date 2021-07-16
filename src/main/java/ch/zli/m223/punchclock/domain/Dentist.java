package ch.zli.m223.punchclock.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The type Dentist.
 */
@Entity
public class Dentist extends User{

    @ManyToOne
    private Ability ability;

    /**
     * Gets ability.
     *
     * @return the ability
     */
    public Ability getAbility() {
        return ability;
    }

    /**
     * Sets ability.
     *
     * @param ability the ability
     */
    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
