package org.onebusaway.transit_data.model;

import java.io.Serializable;

public class AgencyBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private String name;

  private String url;

  private String timezone;

  private String lang;

  private String phone;

  private String disclaimer;

  private boolean privateService;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getDisclaimer() {
    return disclaimer;
  }

  public void setDisclaimer(String disclaimer) {
    this.disclaimer = disclaimer;
  }

  /**
   * @return if true, indicates the agency provides private service that is not
   *         available to the general public.
   */
  public boolean isPrivateService() {
    return privateService;
  }

  public void setPrivateService(boolean privateService) {
    this.privateService = privateService;
  }
}
