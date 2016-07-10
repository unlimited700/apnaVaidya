package com.apnavaidya.treasure.model;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ch.qos.logback.classic.Logger;

@Converter
@Service
public class DescriptionConvertor implements AttributeConverter<String, String> {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(DescriptionConvertor.class);

	@Override
	public String convertToDatabaseColumn(String toEncode) {
		if (toEncode != null)
			try {
				return URLEncoder.encode(toEncode, "UTF-8");
			} catch (Exception ex) {
				logger.error("Exception occured while encoding");
			}
		return toEncode;
	}

	@Override
	public String convertToEntityAttribute(String toDecode) {
		if (toDecode != null && !StringUtils.isEmpty(toDecode)) {
			try {
				return URLDecoder.decode(toDecode, "UTF-8");
			} catch (Exception ex) {
				logger.error("Exception occured while decoding");
				System.out.println("Exception occured while decoding");
			}
		}
		return toDecode;
	}

}
