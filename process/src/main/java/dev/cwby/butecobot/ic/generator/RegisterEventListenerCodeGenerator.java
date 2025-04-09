package dev.cwby.butecobot.ic.generator;

import java.io.IOException;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.lang.model.element.TypeElement;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeSpec;

import dev.cwby.butecobot.ic.EventListenerHandler;

/**
 * AutoRegisterCodeGenerator
 */
public class RegisterEventListenerCodeGenerator implements ICodeGenerator {

	@Override
	public void write(Map<String, TypeElement> elements, Filer filer) {
		var staticBlock = CodeBlock.builder();

		for (Map.Entry<String, TypeElement> e : elements.entrySet()) {
			System.out.println("[ANNOTATION_PROCESSOR] Registering Class: " + e.getKey());
			ClassName listenerToRegister = ClassName.get(e.getValue());
			staticBlock.addStatement("$T.registerEventListener(new $T())", ClassName.get(EventListenerHandler.class),
					listenerToRegister);
		}
		var typeSpec = TypeSpec.classBuilder("AOTInitializer").addStaticBlock(staticBlock.build()).build();

		try {
			JavaFile.builder(getFolderInitializer(), typeSpec).build().writeTo(filer);
		} catch (IOException e) {
			System.out.println("[ANNOTATION_PROCESSOR] Cant write the AOTInitializer to a file: " + e.getMessage());
		}
	}

}
