package org.cph.vhr.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换类，地址栏的String日期转换成Date
 *
 * @author cph
 * @date 2021/02/04
 */
@Component
public class DateConverter implements Converter<String, Date> {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date = null;

	@Override
	public Date convert(String source) {
		if (source != null && source != "") {
			try {
				date = sdf.parse(source);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}
}
