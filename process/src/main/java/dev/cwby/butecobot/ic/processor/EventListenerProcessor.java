package dev.cwby.butecobot.ic.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

import com.google.auto.service.AutoService;

import dev.cwby.butecobot.ic.analyzer.BaseCodeAnalyzer;
import dev.cwby.butecobot.ic.annotation.EventListener;

import dev.cwby.butecobot.ic.generator.RegisterEventListenerCodeGenerator;

/**
 * EventListenerProcessor
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes("dev.cwby.butecobot.ic.annotation.EventListener")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class EventListenerProcessor extends AbstractProcessor {

	private BaseCodeAnalyzer eventListenerAnalyzer;
	private RegisterEventListenerCodeGenerator codeGenerator = new RegisterEventListenerCodeGenerator();
	private ProcessingEnvironment processingEnvironment;
	private Map<String, TypeElement> validElements = new HashMap<>();

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		this.processingEnvironment = processingEnv;
		this.eventListenerAnalyzer = new BaseCodeAnalyzer(processingEnv);
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment re) {
		var interfaceQualifiedName = "net.dv8tion.jda.api.hooks.EventListener";
		Set<TypeElement> allAnnotatedElements = re.getElementsAnnotatedWith(EventListener.class).stream()
				.filter(el -> el.getKind() == ElementKind.CLASS)
				.map(TypeElement.class::cast)
				.filter(typeElement -> eventListenerAnalyzer.implementsInterface(typeElement, interfaceQualifiedName,
						processingEnvironment))
				.collect(Collectors.toSet());

		for (TypeElement element : allAnnotatedElements) {
			System.out.println("[ANNOTATION_PROCESSOR] Found EventListener Valid Class: " + element.getQualifiedName());
			validElements.put(element.getQualifiedName().toString(), element);
		}

		if (re.processingOver()) {
			codeGenerator.write(validElements, processingEnv.getFiler());
		}
		return true;
	}

}
