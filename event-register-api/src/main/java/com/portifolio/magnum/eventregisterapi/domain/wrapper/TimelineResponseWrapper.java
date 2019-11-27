package com.portifolio.magnum.eventregisterapi.domain.wrapper;

import com.portifolio.magnum.eventregisterapi.model.TimeLine;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class TimelineResponseWrapper implements Serializable {

    private List<TimeLine> timeLine = new ArrayList<>();

}
