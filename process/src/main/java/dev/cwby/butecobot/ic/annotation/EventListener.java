package dev.cwby.butecobot.ic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EventListener
 * This Annotation MUST be used along EventListener interface or a class that
 * implements it, and the actual class must have a EMPTY CONSTRUCTOR.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface EventListener {

}
