/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.support.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.util.Assert;

/**
 * General utility methods.
 *
 * @author Gary Russell
 * @since 4.0
 *
 */
public class IntegrationUtils {

	public static final String INTEGRATION_CONVERSION_SERVICE_BEAN_NAME = "integrationConversionService";

	/**
	 * @param beanFactory BeanFactory for lookup, must not be null.
	 * @return The {@link ConversionService} bean whose name is "integrationConversionService" if available.
	 */
	public static ConversionService getConversionService(BeanFactory beanFactory) {
		return getBeanOfType(beanFactory, INTEGRATION_CONVERSION_SERVICE_BEAN_NAME, ConversionService.class);
	}

	private static <T> T getBeanOfType(BeanFactory beanFactory, String beanName, Class<T> type) {
		Assert.notNull(beanFactory, "BeanFactory must not be null");
		if (!beanFactory.containsBean(beanName)) {
			return null;
		}
		return beanFactory.getBean(beanName, type);
	}

}
