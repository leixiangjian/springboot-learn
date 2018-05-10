package com.springboot.learn.configuration.failureanalyzer;

import org.springframework.beans.BeansException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class MyBeanNotOfRequiredTypeFailureAnalyzer extends AbstractFailureAnalyzer<BeansException> {

	@Override
	protected FailureAnalysis analyze(Throwable rootFailure, BeansException cause) {
		return new FailureAnalysis(getDescription(cause), getAction(cause), cause);
	}

	private String getDescription(BeansException ex) {
		/*return String.format("The bean %s could not be injected as %s " + "because it is of type %s", ex.getBeanName(),
				ex.getRequiredType().getName(), ex.getActualType().getName());*/
		return String.format("The bean %s could not be injected as %s " + "because it is of type %s","xx","yy","zz");
	}

	private String getAction(BeansException ex) {
		/*return String.format("Consider creating a bean with name %s of type %s", ex.getBeanName(),
				ex.getRequiredType().getName());*/
		return String.format("Consider creating a bean with name %s of type %s","xx","yy");
	}
}
