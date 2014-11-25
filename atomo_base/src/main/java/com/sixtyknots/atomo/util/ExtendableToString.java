package com.sixtyknots.atomo.util;

/**
 * Abstract class providing support for toString() usage over class inheritance.
 *
 * @author Miroslav Plese
 */
public abstract class ExtendableToString {
    /**
     * Returns the object in String form.
     *
     * @return String form of the object
     */
    protected abstract String toPropertiesString();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + toPropertiesString() + "}";
    }
}
