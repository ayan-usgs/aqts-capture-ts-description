package gov.usgs.wma.waterdata;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessTimeSeriesDescription implements Function<RequestObject, Object> {

	@Autowired
	TimeSeriesDescriptionDao tsdDao;

	@Override
	public  ResultObject apply(RequestObject request) {
		return processRequest(request);
	}

	protected ResultObject processRequest(RequestObject request) {
		ResultObject result = new ResultObject();

		// run the insert
		System.out.println("Here's the input: ");
		System.out.println(request.getId());
		tsdDao.insertTimeSeriesDescriptionsForSingleJsonDataId(request.getId());


//		TODO just hardcoding the result for now, should end up as a list of ts_unique_ids
		Long[] sample_ts_unique_ids = {1L,2L,3L,4L};
		result.setTsDescriptionUniqueIds(sample_ts_unique_ids);
		return result;
	}
}
