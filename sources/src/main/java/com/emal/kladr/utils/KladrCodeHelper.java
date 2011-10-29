package com.emal.kladr.utils;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 10/29/11 11:09 PM
 * <p/>
 * Структура кодового обозначения в блоке "Код":
 * СС РРР ГГГ ППП УУУУ ДДДД, где
 * СС – код субъекта Российской Федерации (региона), коды регионов представлены в Приложении 2 к Описанию классификатора адресов Российской Федерации (КЛАДР);
 * РРР – код района;
 * ГГГ – код города;
 * ППП – код населенного пункта;
 * УУУУ – код улицы (если адрес не содержит наименования улицы, т.е. дома привязаны непосредственно к городу или населенному пункту, то код улицы будет содержать нули – 0000);
 * ДДДД – порядковый номер позиции классификатора с обозначениями домов.
 */

//СС РРР ГГГ ППП УУУУ ДДДД
//01 234 567 890 1234 5678
public class KladrCodeHelper {
    public static String getRegion(String code) {
        return code.substring(0, 2);
    }

    public static String getDistrict(String code) {
        return code.substring(2, 5);
    }

    public static String getCity(String code) {
        return code.substring(5, 8);
    }

    public static String getCountry(String code) {
        return code.substring(8, 11);
    }

    public static String getLocality(String code) {
        return code.substring(5, 11);
    }

    public static String getStreet(String code) {
        return code.substring(11, 15);
    }

    public static String getHouse(String code) {
        return code.substring(15, 19);
    }
}
