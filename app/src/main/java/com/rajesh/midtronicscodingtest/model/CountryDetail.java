package com.rajesh.midtronicscodingtest.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CountryDetail implements Parcelable {

  public final static Creator<CountryDetail> CREATOR = new Creator<CountryDetail>() {


    @SuppressWarnings({
        "unchecked"
    })
    public CountryDetail createFromParcel(Parcel in) {
      return new CountryDetail(in);
    }

    public CountryDetail[] newArray(int size) {
      return (new CountryDetail[size]);
    }

  };
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("topLevelDomain")
  @Expose
  private List<String> topLevelDomain = null;
  @SerializedName("alpha2Code")
  @Expose
  private String alpha2Code;
  @SerializedName("alpha3Code")
  @Expose
  private String alpha3Code;
  @SerializedName("callingCodes")
  @Expose
  private List<String> callingCodes = null;
  @SerializedName("capital")
  @Expose
  private String capital;
  @SerializedName("altSpellings")
  @Expose
  private List<String> altSpellings = null;
  @SerializedName("region")
  @Expose
  private String region;
  @SerializedName("subregion")
  @Expose
  private String subregion;
  @SerializedName("population")
  @Expose
  private Integer population;
  @SerializedName("latlng")
  @Expose
  private List<Double> latlng = null;
  @SerializedName("demonym")
  @Expose
  private String demonym;
  @SerializedName("area")
  @Expose
  private Double area;
  @SerializedName("gini")
  @Expose
  private Double gini;
  @SerializedName("timezones")
  @Expose
  private List<String> timezones = null;
  @SerializedName("borders")
  @Expose
  private List<String> borders = null;
  @SerializedName("nativeName")
  @Expose
  private String nativeName;
  @SerializedName("numericCode")
  @Expose
  private String numericCode;
  @SerializedName("currencies")
  @Expose
  private List<String> currencies = null;
  @SerializedName("languages")
  @Expose
  private List<String> languages = null;
  @SerializedName("translations")
  @Expose
  private Translations translations;
  @SerializedName("relevance")
  @Expose
  private String relevance;

  protected CountryDetail(Parcel in) {
    this.name = ((String) in.readValue((String.class.getClassLoader())));
    in.readList(this.topLevelDomain, (String.class.getClassLoader()));
    this.alpha2Code = ((String) in.readValue((String.class.getClassLoader())));
    this.alpha3Code = ((String) in.readValue((String.class.getClassLoader())));
    in.readList(this.callingCodes, (String.class.getClassLoader()));
    this.capital = ((String) in.readValue((String.class.getClassLoader())));
    in.readList(this.altSpellings, (String.class.getClassLoader()));
    this.region = ((String) in.readValue((String.class.getClassLoader())));
    this.subregion = ((String) in.readValue((String.class.getClassLoader())));
    this.population = ((Integer) in.readValue((Integer.class.getClassLoader())));
    in.readList(this.latlng, (Double.class.getClassLoader()));
    this.demonym = ((String) in.readValue((String.class.getClassLoader())));
    this.area = ((Double) in.readValue((Double.class.getClassLoader())));
    this.gini = ((Double) in.readValue((Double.class.getClassLoader())));
    in.readList(this.timezones, (String.class.getClassLoader()));
    in.readList(this.borders, (String.class.getClassLoader()));
    this.nativeName = ((String) in.readValue((String.class.getClassLoader())));
    this.numericCode = ((String) in.readValue((String.class.getClassLoader())));
    in.readList(this.currencies, (String.class.getClassLoader()));
    in.readList(this.languages, (String.class.getClassLoader()));
    this.translations = ((Translations) in.readValue((Translations.class.getClassLoader())));
    this.relevance = ((String) in.readValue((String.class.getClassLoader())));
  }

  public CountryDetail() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getTopLevelDomain() {
    return topLevelDomain;
  }

  public void setTopLevelDomain(List<String> topLevelDomain) {
    this.topLevelDomain = topLevelDomain;
  }

  public String getAlpha2Code() {
    return alpha2Code;
  }

  public void setAlpha2Code(String alpha2Code) {
    this.alpha2Code = alpha2Code;
  }

  public String getAlpha3Code() {
    return alpha3Code;
  }

  public void setAlpha3Code(String alpha3Code) {
    this.alpha3Code = alpha3Code;
  }

  public List<String> getCallingCodes() {
    return callingCodes;
  }

  public void setCallingCodes(List<String> callingCodes) {
    this.callingCodes = callingCodes;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public List<String> getAltSpellings() {
    return altSpellings;
  }

  public void setAltSpellings(List<String> altSpellings) {
    this.altSpellings = altSpellings;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getSubregion() {
    return subregion;
  }

  public void setSubregion(String subregion) {
    this.subregion = subregion;
  }

  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public List<Double> getLatlng() {
    return latlng;
  }

  public void setLatlng(List<Double> latlng) {
    this.latlng = latlng;
  }

  public String getDemonym() {
    return demonym;
  }

  public void setDemonym(String demonym) {
    this.demonym = demonym;
  }

  public Double getArea() {
    return area;
  }

  public void setArea(Double area) {
    this.area = area;
  }

  public Double getGini() {
    return gini;
  }

  public void setGini(Double gini) {
    this.gini = gini;
  }

  public List<String> getTimezones() {
    return timezones;
  }

  public void setTimezones(List<String> timezones) {
    this.timezones = timezones;
  }

  public List<String> getBorders() {
    return borders;
  }

  public void setBorders(List<String> borders) {
    this.borders = borders;
  }

  public String getNativeName() {
    return nativeName;
  }

  public void setNativeName(String nativeName) {
    this.nativeName = nativeName;
  }

  public String getNumericCode() {
    return numericCode;
  }

  public void setNumericCode(String numericCode) {
    this.numericCode = numericCode;
  }

  public List<String> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(List<String> currencies) {
    this.currencies = currencies;
  }

  public List<String> getLanguages() {
    return languages;
  }

  public void setLanguages(List<String> languages) {
    this.languages = languages;
  }

  public Translations getTranslations() {
    return translations;
  }

  public void setTranslations(Translations translations) {
    this.translations = translations;
  }

  public String getRelevance() {
    return relevance;
  }

  public void setRelevance(String relevance) {
    this.relevance = relevance;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("name", name).append("topLevelDomain", topLevelDomain).append("alpha2Code", alpha2Code).append("alpha3Code", alpha3Code).append("callingCodes", callingCodes).append("capital", capital)
        .append("altSpellings", altSpellings).append("region", region).append("subregion", subregion).append("population", population).append("latlng", latlng).append("demonym", demonym).append("area", area).append("gini", gini)
        .append("timezones", timezones).append("borders", borders).append("nativeName", nativeName).append("numericCode", numericCode).append("currencies", currencies).append("languages", languages).append("translations", translations)
        .append("relevance", relevance).toString();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(region).append(currencies).append(numericCode).append(callingCodes).append(alpha3Code).append(nativeName).append(topLevelDomain).append(altSpellings).append(capital).append(alpha2Code).append(languages)
        .append(subregion).append(timezones).append(area).append(name).append(relevance).append(translations).append(latlng).append(demonym).append(gini).append(borders).append(population).toHashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof CountryDetail) == false) {
      return false;
    }
    CountryDetail rhs = ((CountryDetail) other);
    return new EqualsBuilder().append(region, rhs.region).append(currencies, rhs.currencies).append(numericCode, rhs.numericCode).append(callingCodes, rhs.callingCodes).append(alpha3Code, rhs.alpha3Code).append(nativeName, rhs.nativeName)
        .append(topLevelDomain, rhs.topLevelDomain).append(altSpellings, rhs.altSpellings).append(capital, rhs.capital).append(alpha2Code, rhs.alpha2Code).append(languages, rhs.languages).append(subregion, rhs.subregion).append(timezones, rhs.timezones)
        .append(area, rhs.area).append(name, rhs.name).append(relevance, rhs.relevance).append(translations, rhs.translations).append(latlng, rhs.latlng).append(demonym, rhs.demonym).append(gini, rhs.gini).append(borders, rhs.borders)
        .append(population, rhs.population).isEquals();
  }

  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(name);
    dest.writeList(topLevelDomain);
    dest.writeValue(alpha2Code);
    dest.writeValue(alpha3Code);
    dest.writeList(callingCodes);
    dest.writeValue(capital);
    dest.writeList(altSpellings);
    dest.writeValue(region);
    dest.writeValue(subregion);
    dest.writeValue(population);
    dest.writeList(latlng);
    dest.writeValue(demonym);
    dest.writeValue(area);
    dest.writeValue(gini);
    dest.writeList(timezones);
    dest.writeList(borders);
    dest.writeValue(nativeName);
    dest.writeValue(numericCode);
    dest.writeList(currencies);
    dest.writeList(languages);
    dest.writeValue(translations);
    dest.writeValue(relevance);
  }

  public int describeContents() {
    return 0;
  }

}
