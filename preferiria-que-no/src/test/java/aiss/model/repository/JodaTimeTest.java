package aiss.model.repository;

import static org.junit.Assert.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

public class JodaTimeTest {

	@Test
	public void JodaTimetest() {
		DateTime fecha2 = new DateTime(2018, 6, 1, 17, 0, DateTimeZone.forID("Europe/Madrid"));
		DateTimeFormatter dateFormatter = ISODateTimeFormat.dateTime();
		String endRFC = dateFormatter.print(fecha2);
		assertTrue("La fecha no se ha generado correctamente",
				endRFC.equals("2018-06-01T17:00:00.000+02:00"));
	}

}
