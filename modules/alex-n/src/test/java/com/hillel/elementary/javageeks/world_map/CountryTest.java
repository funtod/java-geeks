package com.hillel.elementary.javageeks.world_map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CountryTest {

    public Country ukraine;

    @BeforeAll
    public void initialiseNewCountry(){
        City kiev = new City("Kiev", new District[]{new District("Pechersky"),
                                                            new District("Podolsky"),
                                                            new District("Golosiyvsky")});
        City odesa = new City("Odesa", new District[]{new District("Tairova"),
                                                            new District("Malinovsky"),
                                                            new District("Primorsky")});
        City ismail = new City("Ismail", new District[]{new District("dis1"),
                                                                new District("dis2"),
                                                                new District("dis3")});
        City boryspil = new City("Boryspil", new District[]{new District("dis1"),
                                                                    new District("dis2"),
                                                                    new District("dis3")});


        Region odeskaOblast = new Region("Odeska oblast",odesa,33314, new City[]{odesa,ismail});
        Region kievskaOblast = new Region("Kievska oblast", kiev, 28121, new City[]{kiev,boryspil});
        Region[] ukraineRegions = new Region[]{odeskaOblast,kievskaOblast};

        ukraine = new Country(kiev, ukraineRegions);
    }

    @Test
    public void expectToGetCapital() {
        assertThat(ukraine.getCapital().getName()).isEqualTo("Kiev");
    }

    @Test
    void expectToGetRegionsNumber() {
        assertThat(ukraine.getRegionsNumber()).isEqualTo(2);
    }

    @Test
    void expectToGetSquare() {
        assertThat(ukraine.getSquare()).isEqualTo(61435);
    }

    @Test
    void expectToGetArrayOfRegionsCenter() {
        City kiev = new City("Kiev", new District[]{new District("Pechersky"),
                new District("Podolsky"),
                new District("Golosiyvsky")});
        City odesa = new City("Odesa", new District[]{new District("Tairova"),
                new District("Malinovsky"),
                new District("Primorsky")});
        City[] regionCenters = new City[]{odesa, kiev};
        assertThat(Arrays.toString(ukraine.getRegionCenters())).isEqualTo(Arrays.toString(regionCenters));
    }
}