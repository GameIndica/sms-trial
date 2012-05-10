package hdcenter.vn.data;

import hdcenter.vn.data.requests.PaggableRequest;
import hdcenter.vn.data.requests.ReqGenres;
import hdcenter.vn.data.requests.ReqMovieCalendars;
import hdcenter.vn.data.requests.ReqMovieDetail;
import hdcenter.vn.data.requests.ReqNewMovies;
import hdcenter.vn.data.requests.ReqRecommendMovies;
import hdcenter.vn.data.requests.ReqSearch;
import hdcenter.vn.data.requests.RequestMoviesList;
import android.content.Context;
import android.os.Handler;


public class DataCenter {



	public static void requestRecommendMovies(int page, IRequestListener listener, Handler handler) {
		RequestWorker.add(new ReqRecommendMovies(page),listener,handler);
	}

	public static void requestNewMovies(int page, IRequestListener listener, Handler handler) {
		RequestWorker.add(new ReqNewMovies(page),listener,handler);
	}

	public static void requestSearch(
			IRequestListener listener, 
			String keyword,
			int page, 
			Handler handler) {
		RequestWorker.add(new ReqSearch(keyword, page), listener, handler);
	}

	public static void requestMovieDetails(IRequestListener listener,String id, Handler handler) {
		RequestWorker.add(new ReqMovieDetail(id), listener, handler);
	}
	
	public static void addMoviesListRequest(RequestMoviesList request, IRequestListener listener, Handler handler) {
		RequestWorker.add(request, listener, handler);
	}

	private static final int FIRST_PAGE = 1;
	public static void requestGenres(Context context, IRequestListener listener, Handler handler) {
		RequestWorker.add(new ReqGenres(context, FIRST_PAGE), listener, handler);
	}

//	public static void requestCollections(IRequestListener listener, Handler handler) {
//		RequestWorker.add(new ReqCollections(), listener, handler);
//	}

	public static void addPaggableRequest(PaggableRequest request, IRequestListener listener, Handler handler) {
		RequestWorker.add(request, listener, handler);
	}

	public static void requestMovieCalendar(String cinemaId, String movieId, IRequestListener listener, Handler handler) {
		RequestWorker.add(new ReqMovieCalendars(cinemaId,movieId), listener, handler);
	}
}
