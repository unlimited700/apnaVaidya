package com.apnavaidya.treasure;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.DispatcherType;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import com.apnavaidya.treasure.constant.URLConstants;
import com.apnavaidya.treasure.filter.TokenAuthenticationFilter;
import com.apnavaidya.treasure.http.HttpClientConfig;

@EnableAutoConfiguration
@Configuration
@ComponentScan("com.apnavaidya.treasure.*")
@EnableJpaRepositories("com.apnavaidya.treasure.dao")
@EnableAsync
@PropertySources({ @PropertySource(value = "classpath:database.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "classpath:app.properties", ignoreResourceNotFound = true) })
@EnableSpringDataWebSupport
@EnableTransactionManagement
public class ApnavaidyaConfig {
	@Bean
	public RestTemplate getRestTemplate(@Qualifier("httpClientConfig") HttpClientConfig httpClientConfig) {
		return new RestTemplate(httpClientConfig.httpRequestFactory());
	}

	@Bean
	@Qualifier("tokenFilter")
	public TokenAuthenticationFilter getTokenAuthFilter() {
		return new TokenAuthenticationFilter();
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean(
			@Qualifier("tokenFilter") TokenAuthenticationFilter tokenAuthenticaitonFilter) {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(tokenAuthenticaitonFilter);
		List<String> urls = new ArrayList<String>(); // TODO Add urls mapping
		// // need to validate
		// urls.add(URLConstants.CITIES);
		// urls.add(URLConstants.APP_CONFIG);
		// urls.add(URLConstants.CATEGORY);
		// urls.add(URLConstants.DEVICES);
		// urls.add(URLConstants.COLLECTION);
		// urls.add(URLConstants.NOTIFICATION);
		// urls.add(URLConstants.OFFERS);
		// urls.add(URLConstants.ORDERS);
		// urls.add(URLConstants.PRODUCTS);
		// urls.add(URLConstants.SEARCH);
		// urls.add(URLConstants.SMS);
		// urls.add(URLConstants.SPAM);
		// urls.add(URLConstants.TILES);
		// urls.add(URLConstants.USERS);
		// urls.add(URLConstants.CHATS);
		// urls.add(URLConstants.V7_APIS);
		// urls.add(URLConstants.V6_HOME);
		// urls.add(URLConstants.V6_HOME_PREVIEW);
		// urls.add(URLConstants.V5_APIS);
		// urls.add(URLConstants.FEEDBACk);
		urls.add(URLConstants.V1_APIS);

		// registrationBean.setUrlPatterns(urls);
		registrationBean.setOrder(2);
		registrationBean.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
		return registrationBean;
	}

}
