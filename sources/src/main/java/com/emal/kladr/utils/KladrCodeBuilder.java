package com.emal.kladr.utils;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 10/26/11 12:14 AM
 *
 * Структура кодового обозначения в блоке "Код":
 * СС РРР ГГГ ППП АА, где
 * СС – код субъекта Российской Федерации (региона), коды регионов представлены в Приложении 2 к Описанию классификатора адресов Российской Федерации (КЛАДР);
 * РРР – код района;
 * ГГГ – код города;
 * ППП – код населенного пункта,
 * АА – признак актуальности адресного объекта.
 */
public class KladrCodeBuilder {
    private String region = "00";
    private String district = "000";
    private String city = "000";
    private String country = "000";
    private String status = "00";

    public static KladrCodeBuilder getInstance() {
        return new KladrCodeBuilder();
    }

    public KladrCodeBuilder addRegion(String region) {
        this.region = region;
        return this;
    }

    public KladrCodeBuilder addDistrict(String district) {
        this.district = district;
        return this;
    }

    public KladrCodeBuilder addCity(String city) {
        this.city = city;
        return this;
    }

    public KladrCodeBuilder addCounty(String country) {
        this.country = country;
        return this;
    }

    public KladrCodeBuilder addStatus(String status) {
        this.status = status;
        return this;
    }

    public String build() {
        return new StringBuffer()
                .append(region)
                .append(district)
                .append(city)
                .append(country)
                .append(status)
                .toString();
    }
}
