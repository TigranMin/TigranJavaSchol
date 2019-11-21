package lesson6;

import java.lang.reflect.Modifier;

public class ModifiersGetterImpl implements ModifiersGetter {

    public String modsGetter(Object obj) {
        int mods = obj.getClass().getModifiers();
        if (Modifier.isProtected(mods)) {
            System.out.println("Calculated by modsGetter: ");
            return "Protected";
        }
        if (Modifier.isPublic(mods)) {
            System.out.print("Calculated by modsGetter: ");
            return "Public";
        }
        if (Modifier.isPrivate((mods))) {
            System.out.print("Calculated by modsGetter: ");
            return "Private";
        }
        if (Modifier.isFinal(mods)) {
            System.out.print("Calculated by modsGetter: ");
            return "Final";
        }
        if (Modifier.isStatic(mods)) {
            System.out.print("Calculated by modsGetter: ");
            return "Static";
        }
        System.out.print("Calculated by modsGetter: ");
        return "Other";
    }
}
