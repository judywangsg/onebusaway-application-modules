package org.onebusaway.api.actions.api.where;

import java.util.Date;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.onebusaway.api.actions.api.ApiActionSupport;
import org.onebusaway.api.model.transit.BeanFactoryV2;
import org.onebusaway.api.model.transit.EntryWithReferencesBean;
import org.onebusaway.api.model.transit.TripDetailsV2Bean;
import org.onebusaway.exceptions.ServiceException;
import org.onebusaway.transit_data.model.TripDetailsBean;
import org.onebusaway.transit_data.model.TripDetailsQueryBean;
import org.onebusaway.transit_data.services.TransitDataService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

public class TripDetailsController extends ApiActionSupport {

  private static final long serialVersionUID = 1L;

  private static final int V2 = 2;

  @Autowired
  private TransitDataService _service;

  private String _id;

  private Date _serviceDate = new Date();

  private Date _time = new Date();
  
  private boolean _includeTrip = true;

  private boolean _includeSchedule = true;
  
  private boolean _includeStatus = true;

  public TripDetailsController() {
    super(V2);
  }

  @RequiredFieldValidator
  public void setId(String id) {
    _id = id;
  }

  public String getId() {
    return _id;
  }

  @TypeConversion(converter = "org.onebusaway.api.impl.DateConverter")
  public void setServiceDate(Date date) {
    _serviceDate = date;
  }

  @TypeConversion(converter = "org.onebusaway.api.impl.DateTimeConverter")
  public void setTime(Date time) {
    _time = time;
  }

  public void setIncludeTrip(boolean includeTrip) {
    _includeTrip = includeTrip;
  }

  public void setIncludeSchedule(boolean includeSchedule) {
    _includeSchedule = includeSchedule;
  }
  
  public void setIncludeStatus(boolean includeStatus) {
    _includeStatus = includeStatus;
  }

  public DefaultHttpHeaders show() throws ServiceException {

    if (!isVersion(V2))
      return setUnknownVersionResponse();

    if (hasErrors())
      return setValidationErrorsResponse();
    
    TripDetailsQueryBean query = new TripDetailsQueryBean();
    query.setTripId(_id);
    query.setServiceDate(_serviceDate);
    query.setTime(_time);
    query.setIncludeTripBean(_includeTrip);
    query.setIncludeTripSchedule(_includeSchedule);
    query.setIncludeTripStatus(_includeStatus);

    TripDetailsBean trip = _service.getSpecificTripDetails(query);

    if (trip == null)
      return setResourceNotFoundResponse();

    BeanFactoryV2 factory = getBeanFactoryV2();
    EntryWithReferencesBean<TripDetailsV2Bean> response = factory.getResponse(trip);
    return setOkResponse(response);
  }
}