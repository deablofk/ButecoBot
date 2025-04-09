package dev.cwby.butecobot.ic.analyzer;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;

/**
 * EventListenerAnalyzer
 */
public class BaseCodeAnalyzer {

	private final Types typeUtils;

	public BaseCodeAnalyzer(ProcessingEnvironment pe) {
		this.typeUtils = pe.getTypeUtils();
	}

	public boolean implementsInterface(TypeElement classElement, String interfaceQualifiedName,
			ProcessingEnvironment processingEnvironment) {
		TypeElement interfaceElement = processingEnvironment.getElementUtils().getTypeElement(interfaceQualifiedName);

		if (interfaceElement == null) {
			return false;
		}

		TypeMirror interfaceType = interfaceElement.asType();
		return typeUtils.isAssignable(classElement.asType(), interfaceType);
	}

}
