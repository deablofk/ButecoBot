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
import dev.cwby.butecobot.ic.annotation.command.SlashCommand;
import dev.cwby.butecobot.ic.generator.SlashCommandCodeGenerator;

/**
 * SlashCommandProcessor
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes("dev.cwby.butecobot.ic.annotation.command.SlashCommand")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class SlashCommandProcessor extends AbstractProcessor {

	private ProcessingEnvironment processingEnvironment;
	private Map<String, TypeElement> validElements = new HashMap<>();
	private SlashCommandCodeGenerator codeGenerator = new SlashCommandCodeGenerator();
	private BaseCodeAnalyzer codeAnalyzer;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		this.processingEnvironment = processingEnv;
		this.codeAnalyzer = new BaseCodeAnalyzer(processingEnv);
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment re) {
		var interfaceQualifiedName = "dev.cwby.butecobot.ic.ISlashCommand";
		Set<TypeElement> allAnnotatedElements = re.getElementsAnnotatedWith(SlashCommand.class).stream()
				.filter(el -> el.getKind() == ElementKind.CLASS)
				.map(TypeElement.class::cast)
				.filter(
						typeElement -> codeAnalyzer.implementsInterface(typeElement, interfaceQualifiedName, processingEnvironment))
				.collect(Collectors.toSet());

		for (TypeElement element : allAnnotatedElements) {
			System.out.println("[ANNOTATION_PROCESSOR] Found SlashCommand Valid Class: " + element.getQualifiedName());
			validElements.put(element.getQualifiedName().toString(), element);
		}

		if (re.processingOver()) {
			codeGenerator.write(validElements, processingEnv.getFiler());
		}

		return true;
	}
}
