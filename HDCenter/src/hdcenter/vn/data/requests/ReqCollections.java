package hdcenter.vn.data.requests;

import hdcenter.vn.entities.CollectionItem;
import hdcenter.vn.entities.MovieCollectionsList;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReqCollections extends Request {

	private static final int FIRST_PAGE = 1;
	private static final String PAGE = "page";
	private static final String ID = "id";
	private static final String ALL = "all";
	private static final String API_COLLECTION = "collection";
	private static final String TOTAL = "total";
	private static final String RESULT = "result";

	@Override
	protected String provideAPIName() {
		return API_COLLECTION;
	}

	@Override
	protected void provideParameters(HashMap<String, String> parameters) {
		parameters.put(PAGE, String.valueOf(FIRST_PAGE));
		parameters.put(ID, ALL);
	}

	@Override
	protected MovieCollectionsList parseData(String resultString) throws JSONException {
		MovieCollectionsList list = new MovieCollectionsList();
		JSONObject object = new JSONObject(resultString);
		int total = object.getInt(TOTAL);
		if ( total != 0 ) {
			JSONArray array = object.getJSONArray(RESULT);
			for(int i = 0 ; i < array.length() ; i++) {
				CollectionItem item = CollectionItem.create(array.getJSONObject(i));
				list.add(item);
			}			
		}
		return list;
	}

}
