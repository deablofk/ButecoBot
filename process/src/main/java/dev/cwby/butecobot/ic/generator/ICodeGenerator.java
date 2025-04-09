package dev.cwby.butecobot.ic.generator;

import java.util.Map;

import javax.annotation.processing.Filer;
import javax.lang.model.element.TypeElement;

/**
 * ICodeGenerator
 */
public interface ICodeGenerator {

	// the folder that the code will be generated in
	default String getFolderInitializer() {
		return "dev.cwby.butecobot.ic.initializer";
	}

	public void write(Map<String, TypeElement> elements, Filer filer);

}
