package com.hillel.elementary.javageeks.examples.tests;

import java.util.Objects;

public class ElementFinder {

    public static Container findById(Long id, Container[] containers) {
        if (containers == null) return null;

        for (Container container : containers) {
            if (container != null
                    && container.id != null
                    && container.id == id) return container;
        }

        return null;
    }

    public static boolean contains(Container container, Container[] containers) {
        if (containers == null) return false;

        for (Container currentContainer : containers) {
            if (currentContainer != null && currentContainer.equals(container))
                return true;
        }

        return false;
    }
}


final class Container {
    public final Long id;
    public final String label;
    public final InnerContainer innerContainer;


    public Container(Long id) {
        this(id, null, null);
    }

    public Container(Long id, String label, InnerContainer innerContainer) {
        this.id = id;
        this.label = label;
        this.innerContainer = innerContainer;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;

        Container otherContainer = (Container) other;

        if (!otherContainer.id.equals(this.id)) return false;
        if (otherContainer.label == null && this.label != null) return false;
        if (otherContainer.label != null && !otherContainer.label.equals(this.label)) return false;

        if(otherContainer.innerContainer != null && this.innerContainer == null) return false;
        return otherContainer.innerContainer.equals(this.innerContainer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, label, innerContainer);
    }
}

final class InnerContainer {
    public final String name;


    InnerContainer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnerContainer that = (InnerContainer) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}