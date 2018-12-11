package com.rajesh.midtronicscodingtest.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Translations implements Parcelable {

  public final static Creator<Translations> CREATOR = new Creator<Translations>() {


    @SuppressWarnings({
        "unchecked"
    })
    public Translations createFromParcel(Parcel in) {
      return new Translations(in);
    }

    public Translations[] newArray(int size) {
      return (new Translations[size]);
    }

  };
  @SerializedName("de")
  @Expose
  private String de;
  @SerializedName("es")
  @Expose
  private String es;
  @SerializedName("fr")
  @Expose
  private String fr;
  @SerializedName("ja")
  @Expose
  private String ja;
  @SerializedName("it")
  @Expose
  private String it;

  protected Translations(Parcel in) {
    this.de = ((String) in.readValue((String.class.getClassLoader())));
    this.es = ((String) in.readValue((String.class.getClassLoader())));
    this.fr = ((String) in.readValue((String.class.getClassLoader())));
    this.ja = ((String) in.readValue((String.class.getClassLoader())));
    this.it = ((String) in.readValue((String.class.getClassLoader())));
  }

  public Translations() {
  }

  public String getDe() {
    return de;
  }

  public void setDe(String de) {
    this.de = de;
  }

  public String getEs() {
    return es;
  }

  public void setEs(String es) {
    this.es = es;
  }

  public String getFr() {
    return fr;
  }

  public void setFr(String fr) {
    this.fr = fr;
  }

  public String getJa() {
    return ja;
  }

  public void setJa(String ja) {
    this.ja = ja;
  }

  public String getIt() {
    return it;
  }

  public void setIt(String it) {
    this.it = it;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("de", de).append("es", es).append("fr", fr).append("ja", ja).append("it", it).toString();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(de).append(it).append(fr).append(es).append(ja).toHashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof Translations) == false) {
      return false;
    }
    Translations rhs = ((Translations) other);
    return new EqualsBuilder().append(de, rhs.de).append(it, rhs.it).append(fr, rhs.fr).append(es, rhs.es).append(ja, rhs.ja).isEquals();
  }

  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(de);
    dest.writeValue(es);
    dest.writeValue(fr);
    dest.writeValue(ja);
    dest.writeValue(it);
  }

  public int describeContents() {
    return 0;
  }

}
